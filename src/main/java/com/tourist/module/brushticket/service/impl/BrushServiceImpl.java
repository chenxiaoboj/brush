package com.tourist.module.brushticket.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tourist.module.brushticket.dao.BrushTicketInfoDao;
import com.tourist.module.brushticket.dao.TouristInfoDao;
import com.tourist.module.brushticket.dto.Paramet;
import com.tourist.module.brushticket.entity.BrushTicketInfo;
import com.tourist.module.brushticket.entity.TouristInfo;
import com.tourist.module.brushticket.service.BrushService;
import com.tourist.module.brushticket.service.component.BrushComponent;
import com.tourist.module.utils.IpUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author chenx 2018-12-03 16:40
 */
@Service
public class BrushServiceImpl implements BrushService {

    private static final Logger logger = LoggerFactory.getLogger(BrushServiceImpl.class);
    private static final String YLXS_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/getDamoYlxsTimeList.json?goods_id=";
    private static final String IP_URL = "http://www.89ip.cn/";

    @Resource
    private TouristInfoDao touristInfoDao;
    @Resource
    private BrushComponent brushComponent;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private BrushTicketInfoDao brushTicketInfoDao;


    /**
     * 启动刷票
     *
     * @param goodId
     */
    @Override
    public String brush(String goodId, Double coefficient) {
        //总游客量
        String resultString = "";
        List<TouristInfo> touristInfoList = touristInfoDao.findAll();
        List<TouristInfo> touristRemark = touristInfoDao.getRemarks();
        List<String> remarksList = Lists.newArrayList();
        touristRemark.forEach(touristInfo -> {
            remarksList.add(touristInfo.getRemarks());
        });
        //请求参数（已经分组的游客）
        List<Paramet> parameterList = this.getParamet(touristInfoList, goodId, remarksList);
        Map<String, Integer> map = this.getDamoYlxsTimeList(goodId);
        if (map == null) {
            resultString = "------------获取余票结果失败";
            return "------------获取余票结果失败";
        }
        AtomicInteger number = new AtomicInteger();
        map.forEach((key, value) -> {
            number.addAndGet(value);
        });
        if (number.get() < touristInfoList.size()) {
            resultString = "票量不足，部分游客可能抢不到票！";
            logger.info("票量不足，部分游客可能抢不到票！------------游客量：" + touristInfoList.size() + "---票总量：" + number.get());
        }
        List<List<Paramet>> parameters = this.getParameterList(parameterList, map, touristInfoList.size(), number.get(), coefficient);
        parameters.forEach(parametList -> {
            this.sendRequest(parametList);
        });
        return resultString;
    }

    @Override
    public String getIps(Integer count) {
        if (count < 10) {
            List<BrushTicketInfo> newList = Lists.newArrayList();
            String input = null;
            try {
                input = FileUtils.readFileToString(new File("D:\\GIT\\ideaProject\\brush\\ips.json"), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject.parseObject(input).getJSONArray("data").forEach(ipJson -> {
                JSONObject jsonIp = (JSONObject) ipJson;
                String[] ipString = jsonIp.getString("IP").split(":");
                if (IpUtil.checkIp(ipString[0], Integer.parseInt(ipString[1]))) {
                    BrushTicketInfo brushTicketInfo = new BrushTicketInfo();
                    brushTicketInfo.setDelFlag("1");
                    brushTicketInfo.setHostName(ipString[0]);
                    brushTicketInfo.setPort(Integer.parseInt(ipString[1]));
                    newList.add(brushTicketInfo);
                }
            });
            brushTicketInfoDao.save(newList);
            return "success";
        }
        List<BrushTicketInfo> list = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            try {
                Document document = Jsoup.connect(IP_URL + "index_" + i + ".html").get();
                Elements elements = document.body().selectFirst("tbody").select("tr");
                elements.forEach(element -> {
                    BrushTicketInfo brushTicketInfo = new BrushTicketInfo();
                    Elements tdElements = element.select("td");
                    brushTicketInfo.setHostName(tdElements.get(0).text());
                    brushTicketInfo.setPort(Integer.parseInt(tdElements.get(1).text()));
                    brushTicketInfo.setAddress(tdElements.get(2).text());
                    brushTicketInfo.setOperatorType(tdElements.get(3).text());
                    brushTicketInfo.setDelFlag("0");
                    try {
                        brushTicketInfo.setEndTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(tdElements.get(4).text()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    list.add(brushTicketInfo);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        brushTicketInfoDao.save(list);
        return "success";
    }

    /**
     * 获取余票信息
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
            if (number > 5) {
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
    public void sendRequest(List<Paramet> parametList) {
        List<BrushTicketInfo> brushTicketDtoList = brushTicketInfoDao.findAllByDelFlag("1");
        AtomicInteger i = new AtomicInteger();
        parametList.forEach(paramet -> {
            List<NameValuePair> list = Lists.newArrayList();
            list.add(new BasicNameValuePair("goods_id", paramet.getGoodsId()));
            list.add(new BasicNameValuePair("play_date", paramet.getPlayDate()));
            list.add(new BasicNameValuePair("amount", paramet.getAmount() + ""));
            list.add(new BasicNameValuePair("time_slot_damoylxs[]", paramet.getTimeSlotDamoylxs()));
            list.add(new BasicNameValuePair("name", paramet.getName()));
            list.add(new BasicNameValuePair("mobile", paramet.getMobile()));
            list.add(new BasicNameValuePair("id_number", paramet.getIdNumber()));
            List<TouristInfo> list1 = paramet.getTouristInfoList();
            list1.forEach(clientInfoFirst -> {
                NameValuePair nameValuePair = new BasicNameValuePair("id_number_list[]", clientInfoFirst.getIdNumber());
                NameValuePair nameValuePair1 = new BasicNameValuePair("player_name_list[]", clientInfoFirst.getName());
                NameValuePair nameValuePair2 = new BasicNameValuePair("player_mobile_list[]", clientInfoFirst.getMobile());
                list.add(nameValuePair);
                list.add(nameValuePair1);
                list.add(nameValuePair2);
            });
            //参数
            NameValuePair[] nvps = list.toArray(new NameValuePair[list.size()]);
            //@TODO 获取代理信息，每个线程分发一个代理ip
            brushComponent.getEwmUrl(brushTicketDtoList.get(i.get()), nvps, paramet.getMobile());
            i.addAndGet(1);
        });
    }
}
