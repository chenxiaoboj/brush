package com.lanjchenx.module.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author chenxiaobo 2019-04-10 23:36
 */
public class IdCardCheckUtil {

    private static final String LESS_URL = "http://localhost:8025/codReport/platformEarningsRepair";

    public static void main(String[] args) throws IOException {

//        for (int i = 30; i >=1 ; i--) {
//            Long time = LocalDateTime.now().minusDays(i).toInstant(ZoneOffset.of("+8")).toEpochMilli();
//            System.out.println(time);
            try {
                CloseableHttpClient httpclient = HttpClients
                        .custom()
                        .setDefaultCookieStore(new BasicCookieStore())
                        .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                        .build();
                CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post().setUri(LESS_URL)
                        .setHeader("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsY0lkIjoiIiwiaW50ZXJjb25uZWN0Q29tcGFueUNvZGUiOm51bGwsImVtcElkIjoiOUQ0OTJDM0EyRTA0NDJCMjg4RDg2QkUyQzQwQjgyODIiLCJkZXB0TmFtZSI6IuiagemTvuaAu-mDqCIsImVtcE1vYmlsZSI6IiIsInBhc3N3b3JkVGltZSI6eyJuYW5vcyI6MH0sImdlbmRlciI6IiIsImNvbXBhbnlOYW1lIjoi5LiK5rW36JqB6ZO-54mp5rWBIiwibG9naW5Db2RlIjoiQURNSU4iLCJyZW1hcmsiOiIiLCJkZXB0Tm8iOiJZTFpCIiwiZW1wVXBkUm9sZSI6IjU4OTAxIiwiaXNTYWFzU3lzdGVtIjoiMCIsImludGVyY29ubmVjdENvbXBhbnlJZCI6bnVsbCwidXBkVXNlciI6IkFOVENIQUlOIiwidXBkVGltZSI6eyJuYW5vcyI6MH0sImVtcE5hbWUiOiLnrqHnkIblkZgiLCJsb2dpblBhc3N3b3JkIjoiMTIzNDU2IiwiaXNJbnRlcmNvbm5lY3QiOm51bGwsImludGVyY29ubmVjdENvbXBhbnlOYW1lIjpudWxsLCJpYXQiOjE2MDYzMDAzMjQwMjQsImFkZHJlc3MiOiIiLCJhdXRoTG9naW4iOiIxIiwiY29tcGFueVR5cGUiOiIxODQwMSIsImRlcHRJZCI6IjAwMjA3MiIsImRlcHRUeXBlQ29kZSI6IjEyMDA1IiwiYWN0aXZlIjoiMSIsImNvbXBhbnlJZCI6IjEwMDEiLCJlbXBDb2RlIjoiQURNSU4iLCJleHBpcmUiOjE2MDYzMDM5MjQwMjQsImJyYW5kSWQiOiIiLCJwYXJlbnRFbXBDb2RlIjoiIiwiaWRjYXJkIjoiIiwidGVuYW50SWQiOiIxMDEifQ.oGlTH9JlUJw1I_76QyWronRgaaSF0pddYUgleItvP50")
//                        .addParameter("date", time+"")
                        .addParameter("mark", "1")
                        .addParameter("terminal", "pc")
                        .build());
                String result = EntityUtils.toString(http1.getEntity());
//                System.out.println("----------- i: "+i+result);
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
    }



}
