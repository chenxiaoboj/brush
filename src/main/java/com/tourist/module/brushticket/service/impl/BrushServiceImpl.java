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
import java.io.IOException;
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
    private static final String YLXS_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/getDamoYlxsTimeList.json?goods_id=1843845&play_date=2019-02-22";
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
    public String brush(String goodId) {
        //总游客量
        String resultString = "";
        List<TouristInfo> touristInfoList = touristInfoDao.findAll();
        List<TouristInfo> touristRemark = touristInfoDao.getRemarks();
        List<String> remarksList = Lists.newArrayList();
        touristRemark.forEach(touristInfo -> {
            remarksList.add(touristInfo.getRemarks());
        });
        List<Paramet> parameterList = this.getParamet(touristInfoList, goodId, remarksList);
        Map<String, Integer> map = this.getDamoYlxsTimeList();
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
            logger.info("票量不足，部分游客可能抢不到票！");
        }
        List<List<Paramet>> parameters = this.getParameterList(parameterList, map, number.get());
        parameters.forEach(parametList -> {
            this.sendRequest(parametList);
        });
        return resultString;
    }

    @Override
    public String getIps() {
        List<BrushTicketInfo> list = Lists.newArrayList();
        for (int i = 0; i < 6; i++) {
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
    public Map<String, Integer> getDamoYlxsTimeList() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(YLXS_URL, String.class);
        JSONObject resultJson = JSONObject.parseObject(responseEntity.getBody());
        if (!StringUtils.equalsIgnoreCase("true", resultJson.getString("success"))) {
            logger.info("------------获取余票结果失败");
            return null;
        }
        JSONArray jsonArray = resultJson.getJSONObject("list").getJSONArray("_100000000013");
        List<Map<String, Integer>> numberList = Lists.newArrayList();
        Map<String, Integer> map = Maps.newHashMap();
        jsonArray.forEach(jsonObject -> {
            JSONObject jsonObject1 = (JSONObject) jsonObject;
            String id = jsonObject1.getString("id");
            String[] tt = jsonObject1.getString("text").split(":");
            Integer number = Integer.parseInt(tt[tt.length - 1]);
            if (number > 0) {
                map.put(id, number);
            }
        });
        return map;
    }

    /**
     * 根据各个时间点的剩余票量分发游客任务
     *
     * @param parameterList
     * @param timeAndNumberMap
     * @return
     */
    public List<List<Paramet>> getParameterList(List<Paramet> parameterList, Map<String, Integer> timeAndNumberMap, Integer number) {
        List<List<Paramet>> lists = Lists.newArrayList();
        //人数index
        AtomicInteger index = new AtomicInteger();
        //总票量 number
        AtomicInteger valueNumber = new AtomicInteger();
        timeAndNumberMap.forEach((key, value) -> {
            valueNumber.addAndGet(value);
            List<Paramet> list = Lists.newArrayList();
            //3.00-3.30 ,50
            //人数
            int count = 0;
            for (int i = 0; i < value; i++) {
                try {
                    count += (parameterList.get(index.get() + i).getTouristInfoList().size() + 1);
                } catch (IndexOutOfBoundsException e) {
                    logger.info("所有游客已经分配完毕，剩余票量充足-----" + e);
                    return;
                }
                if (count < value) {
                    parameterList.get(index.get() + i).setTimeSlotDamoylxs(key);
                    list.add(parameterList.get(index.get() + i));
                } else {
                    break;
                }
            }
            index.addAndGet(value + 1);
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
        List<List<TouristInfo>> clientInfoList = null;
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
        List<BrushTicketInfo> brushTicketDtoList = brushTicketInfoDao.findAll();
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
