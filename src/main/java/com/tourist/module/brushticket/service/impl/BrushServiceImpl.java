package com.tourist.module.brushticket.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tourist.module.brushticket.dao.*;
import com.tourist.module.brushticket.dto.Paramet;
import com.tourist.module.brushticket.entity.*;
import com.tourist.module.brushticket.service.BrushService;
import com.tourist.module.brushticket.service.component.BrushComponent;
import com.tourist.module.brushticket.service.component.FirstTest;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author chenx 2018-12-03 16:40
 */
@Service
public class BrushServiceImpl implements BrushService {

    private static final Logger logger = LoggerFactory.getLogger(BrushServiceImpl.class);
    private static final String YLXS_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/getDamoYlxsTimeList.json?goods_id=";

    @Resource
    private TouristInfoDao touristInfoDao;
    @Resource
    private BrushComponent brushComponent;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private BrushTicketInfoDao brushTicketInfoDao;
    @Resource
    private FirstTest firstTest;
    @Resource
    private SuccessOrderInfoDao successOrderInfoDao;
    @Resource
    private ExceptionInfoDao exceptionInfoDao;
    @Resource
    private FenzuEntityDao fenzuEntityDao;


    /**
     * 启动刷票
     *
     * @param goodId
     */
    @Override
    public String brush(String goodId, Double coefficient, String ipUrl) {
        String resultString = "";
        Map<String, Integer> map = this.getDamoYlxsTimeList(goodId);
        if (map == null) {
            resultString = "------------获取余票结果失败";
            return "------------获取余票结果失败";
        }
        //总游客量
        List<TouristInfo> touristInfoList = touristInfoDao.findAll();
        List<TouristInfo> touristRemark = touristInfoDao.getRemarks();
        List<String> remarksList = Lists.newArrayList();
        touristRemark.forEach(touristInfo -> {
            remarksList.add(touristInfo.getRemarks());
        });
        //请求参数（已经分组的游客）
        List<Paramet> parameterList = this.getParamet(touristInfoList, goodId, remarksList);
        AtomicInteger number = new AtomicInteger();
        map.forEach((key, value) -> {
            number.addAndGet(value);
        });
        if (number.get() < touristInfoList.size()) {
            resultString = "票量不足，部分游客可能抢不到票！";
            logger.info("票量不足，部分游客可能抢不到票！------------游客量：" + touristInfoList.size() + "---票总量：" + number.get());
        }
        List<List<Paramet>> parameters = this.getParameterList(parameterList, map, touristInfoList.size(), number.get(), coefficient);
        //抓取ip地址
        List<BrushTicketInfo> brushTicketDtoList = this.getIp(ipUrl);
        AtomicInteger fromIndex = new AtomicInteger();
        parameters.forEach(parametList -> {
            this.sendRequest(parametList, brushTicketDtoList.subList(fromIndex.get(), fromIndex.get() + parametList.size()));
            fromIndex.addAndGet(parametList.size());
        });
        return resultString;
    }

    @Override
    public String testOk(String ipUrl) {
        List<BrushTicketInfo> brushTicketDtoList = this.getIp(ipUrl);
        List<NameValuePair> list = Lists.newArrayList();
        list.add(new BasicNameValuePair("goods_id", "1843845"));
        list.add(new BasicNameValuePair("pintuan_id", ""));
        list.add(new BasicNameValuePair("play_date", new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        list.add(new BasicNameValuePair("time_slot_damoylxs[]", "100000130451|100000000013|13:00:00-13:29:59|100"));
        list.add(new BasicNameValuePair("amount", "1"));
        list.add(new BasicNameValuePair("g_batch_type", "2"));
        list.add(new BasicNameValuePair("name", "陈台"));
        list.add(new BasicNameValuePair("mobile", "13114562158"));
        list.add(new BasicNameValuePair("id_number", "430903198805124540"));
//        参数
        NameValuePair[] nvps = list.toArray(new NameValuePair[list.size()]);
        while (true) {
            if (StringUtils.equals("true", firstTest.firstTest(brushTicketDtoList.get(RandomUtils.nextInt(0, brushTicketDtoList.size())), nvps, "1843845"))) {
                break;
            }
        }
        return "success";
    }

    @Override
    public String disposeException() {
        try {
            brushComponent.getEwm();
            return "success";
        } catch (Exception e) {
            return "系统异常";
        }
    }

    @Override
    public String disposeExceptionIO(String ipUrl) {
        List<BrushExceptionInfo> exceptionInfoList = exceptionInfoDao.findAllByCountAndDelFlag(4, "0");
        List<BrushTicketInfo> brushTicketDtoList = this.getIp(ipUrl);
        AtomicInteger i = new AtomicInteger();
        exceptionInfoList.forEach(brushExceptionInfo -> {
            String time = this.getTime("1843845");
            if (StringUtils.isBlank(time)) {
                logger.info("无票可抢！");
                return;
            }
            List<NameValuePair> list = Lists.newArrayList();
            String s = brushExceptionInfo.getParameter().replace(" ", "");
            String[] params = s.substring(1, s.length() - 1).split(",");
            for (int i1 = 0; i1 < params.length; i1++) {
                String para[] = params[i1].split("=");
                String value;
                try {
                    value = para[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    value = "";
                }
                if (StringUtils.equalsIgnoreCase("time_slot_damoylxs[]", para[0])) {
                    value = time;
//                    value = "100000128631|100000000013|10:30:00-10:59:59|5";
                }
                list.add(new BasicNameValuePair(para[0], value));
            }
            NameValuePair[] nvps = list.toArray(new NameValuePair[list.size()]);
            logger.info("----处理IO异常数据-------------：" + list.toString());
            brushComponent.getEwmUrl(brushTicketDtoList.get(i.get()), nvps,
                    brushExceptionInfo.getMobile(), brushExceptionInfo.getNumber(), "1843845", brushExceptionInfo.getName());
            i.getAndIncrement();
            brushExceptionInfo.setDelFlag("1");
        });
        exceptionInfoDao.save(exceptionInfoList);
        return "success";
    }

    @Override
    public List<BrushExceptionInfo> getExceptionList() {
        return exceptionInfoDao.findAllByDelFlag("0");
    }

    public void exceptionIO() {

    }

    @Override
    @Transactional
    public String changeStatus(Integer id) {
        successOrderInfoDao.changeStatus(id);
        return "success";
    }

    @Override
    public void testThread() {
        List<BrushTicketInfo> brushTicketDtoList = brushTicketInfoDao.findAllByDelFlag("1");
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }
        AtomicInteger j = new AtomicInteger();
        brushTicketDtoList.forEach(brushTicketInfo -> {
            System.out.println(System.currentTimeMillis() + "-----" + j);
            brushComponent.test(brushTicketInfo);
            j.getAndIncrement();
        });
    }

    @Override
    public List<SuccessOrderInfo> getEwmList() {
        List<SuccessOrderInfo> list = successOrderInfoDao.findAll();
        return list;
    }

    @Override
    public void fenzu() {
        List<String> list = touristInfoDao.getFenzu();
        List<FenzuEntity> listFenzu = Lists.newArrayList();
        AtomicInteger i = new AtomicInteger();
        list.forEach(s -> {
            FenzuEntity fenzuEntity = new FenzuEntity();
            List<TouristInfo> listfenzu = touristInfoDao.findAllByRemarks(s);
            AtomicReference<String> fenzus = new AtomicReference<>("");
            listfenzu.forEach(brushTicketInfo -> {
                fenzus.updateAndGet(v -> v + brushTicketInfo.getId() + "|");
            });
            fenzuEntity.setGroupName(s);
            fenzuEntity.setIdList(fenzus.get().substring(0, fenzus.get().length() - 1));
            fenzuEntity.setCount(listfenzu.size());
            listFenzu.add(fenzuEntity);
        });
        fenzuEntityDao.save(listFenzu);
    }

    @Override
    public void ips(String ipUrl) {
        for (int i = 0; i < 1; i++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.getIp(ipUrl);
        }
    }

    /**
     * 获取余票信息
     */
    public String getTime(String goodId) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(YLXS_URL + goodId + "&play_date=", String.class);
        JSONObject resultJson = JSONObject.parseObject(responseEntity.getBody());
        if (!StringUtils.equalsIgnoreCase("true", resultJson.getString("success"))) {
            logger.info("-----------获取余票结果失败");
            return null;
        }
        JSONArray jsonArray = resultJson.getJSONObject("list").getJSONArray("_100000000013");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            String id = jsonObject1.getString("id");
            String[] tt = jsonObject1.getString("text").split(":");
            if (Integer.parseInt(tt[tt.length - 1]) > 0 && StringUtils.equalsIgnoreCase("false", jsonObject1.getString("disabled"))) {
                logger.info("剩余票量----" + id + "--------" + Integer.parseInt(tt[tt.length - 1]));
                return id;
            }
        }
        return null;
    }

    /**
     * 获取余票信息
     *
     * @param goodId
     * @return
     */
    public Map<String, Integer> getDamoYlxsTimeList(String goodId) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(YLXS_URL + goodId + "&play_date=", String.class);
        JSONObject resultJson = JSONObject.parseObject(responseEntity.getBody());
        if (!StringUtils.equalsIgnoreCase("true", resultJson.getString("success"))) {
            logger.info("------------获取余票结果失败");
            return null;
        }
        JSONArray jsonArray = resultJson.getJSONObject("list").getJSONArray("_100000000014");
        Map<String, Integer> map = Maps.newHashMap();
        jsonArray.forEach(jsonObject -> {
            JSONObject jsonObject1 = (JSONObject) jsonObject;
            String id = jsonObject1.getString("id");
            String[] tt = jsonObject1.getString("text").split(":");
            Integer number = Integer.parseInt(tt[tt.length - 1]);
            if (number > 6 && StringUtils.equalsIgnoreCase("false", jsonObject1.getString("disabled"))) {
                map.put(id, number);
            }
        });
        return map;
    }

    /**
     * 根据各个时间点的剩余票量分发游客任务
     *
     * @param parameterList    分发参数
     * @param timeAndNumberMap 时间参数和当前票量
     * @param peopleNumber     总游客数量
     * @param piaoNumber       票总量
     * @param coefficient      抢票系数（当前时间票量*系数=当前抢票任务量）
     * @return
     */
    public List<List<Paramet>> getParameterList(List<Paramet> parameterList, Map<String, Integer> timeAndNumberMap, Integer peopleNumber, Integer piaoNumber, Double coefficient) {
        List<List<Paramet>> lists = Lists.newArrayList();
        //已用票数
        AtomicInteger valueNumber = new AtomicInteger();
        //参数列表下标
        AtomicInteger parameterIndex = new AtomicInteger();
        //遍历时间---当前时间票量
        timeAndNumberMap.forEach((key, value) -> {
            if (valueNumber.get() == peopleNumber) {
                return;
            }
            //人数 index
            AtomicInteger index = new AtomicInteger();
            //当前时间点抢票任务量
            int renwuNumber = (int) (value * coefficient);
            List<Paramet> list = Lists.newArrayList();
            for (int i = 0; i < parameterList.size(); i++) {
                if (index.get() >= renwuNumber) {
                    logger.info("该时间段票数分发完毕！----" + key + "任务量1:---" + renwuNumber);
                    break;
                }
                if (parameterIndex.get() >= parameterList.size()) {
                    logger.info("该时间段票数分发完毕！----" + key + "任务量2:---" + renwuNumber);
                    break;
                }
                //本次请求参数有多少人
                int renshu = parameterList.get(parameterIndex.get()).getTouristInfoList().size() + 1;
                index.addAndGet(renshu);
                //设置本次请求时间段参数
                parameterList.get(parameterIndex.get()).setTimeSlotDamoylxs(key);
                list.add(parameterList.get(parameterIndex.get()));
                parameterIndex.addAndGet(1);
            }
            valueNumber.addAndGet(index.get());
            lists.add(list);
        });
        return lists;
    }


    /**
     * 得到参数集合
     *
     * @param list
     * @param goodId
     * @param remarksList
     * @return
     */
    public List<Paramet> getParamet(List<TouristInfo> list, String goodId, List<String> remarksList) {
        //根据手机号标记进行分组
        List<List<TouristInfo>> clientInfoList = Lists.newArrayList();
        remarksList.forEach(remark -> {
            List<TouristInfo> listResult = list.stream().filter(
                    touristInfo -> StringUtils.equalsIgnoreCase(touristInfo.getRemarks(), remark))
                    .collect(Collectors.toList());
            clientInfoList.add(listResult);
        });
        List<Paramet> parametList = Lists.newArrayList();
        clientInfoList.forEach(list1 -> {
            //封装完整的一条参数
            Paramet paramet = new Paramet();
            paramet.setGoodsId(goodId);
            paramet.setIdNumber(list1.get(0).getIdNumber());
            paramet.setName(list1.get(0).getName());
            paramet.setPlayDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            paramet.setMobile(list1.get(0).getMobile());
            paramet.setAmount(list1.size());
            list1.remove(0);
            paramet.setTouristInfoList(list1);
            parametList.add(paramet);
        });
        return parametList;
    }


    /**
     * 批量发送请求
     *
     * @param parametList
     */
    public void sendRequest(List<Paramet> parametList, List<BrushTicketInfo> brushTicketDtoList) {
        AtomicInteger i = new AtomicInteger();
        parametList.forEach(paramet -> {
            List<NameValuePair> list = Lists.newArrayList();
            list.add(new BasicNameValuePair("goods_id", paramet.getGoodsId()));
            list.add(new BasicNameValuePair("pintuan_id", ""));
            list.add(new BasicNameValuePair("play_date", paramet.getPlayDate()));
            list.add(new BasicNameValuePair("time_slot_damoylxs[]", paramet.getTimeSlotDamoylxs()));
            list.add(new BasicNameValuePair("amount", paramet.getAmount() + ""));
            list.add(new BasicNameValuePair("g_batch_type", "2"));
            list.add(new BasicNameValuePair("name", paramet.getName()));
            list.add(new BasicNameValuePair("mobile", paramet.getMobile()));
            list.add(new BasicNameValuePair("id_number", paramet.getIdNumber()));
            List<TouristInfo> list1 = paramet.getTouristInfoList();
            list1.forEach(clientInfoFirst -> {
                NameValuePair nameValuePair1 = new BasicNameValuePair("player_name_list[]", clientInfoFirst.getName());
                NameValuePair nameValuePair2 = new BasicNameValuePair("player_mobile_list[]", clientInfoFirst.getMobile());
                NameValuePair nameValuePair = new BasicNameValuePair("id_number_list[]", clientInfoFirst.getIdNumber());
                list.add(nameValuePair);
                list.add(nameValuePair1);
                list.add(nameValuePair2);
            });
            //参数
            NameValuePair[] nvps = list.toArray(new NameValuePair[list.size()]);
            //@TODO 获取代理信息，每个线程分发一个代理ip
            System.out.println(System.currentTimeMillis() + "-----" + i.get());
            brushComponent.getEwmUrl(brushTicketDtoList.get(i.get()), nvps, paramet.getMobile(), paramet.getAmount(), "1843845", paramet.getName());
            i.getAndIncrement();
        });
    }

    /**
     * 抓取ip
     *
     * @param ipUrl
     * @return
     */
    public List<BrushTicketInfo> getIp(String ipUrl) {
        List<BrushTicketInfo> ipMap = Lists.newArrayList();
        Map<String, Integer> map = Maps.newHashMap();
        try {
            Document document = Jsoup.connect(ipUrl).get();
            String ips = document.body().text();
            String[] ipArray = ips.split(";");
            for (int i = 0; i < ipArray.length; i++) {
                map.put(ipArray[i].split(":")[0], Integer.parseInt(ipArray[i].split(":")[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.forEach((key, value) -> {
            BrushTicketInfo brushTicketInfo = new BrushTicketInfo();
            brushTicketInfo.setHostName(key);
            brushTicketInfo.setPort(value);
            ipMap.add(brushTicketInfo);
        });
        return ipMap;
    }

}
