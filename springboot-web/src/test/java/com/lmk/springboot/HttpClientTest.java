package com.lmk.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuMengKe
 * @create 2019-01-12-20:17
 */
public class HttpClientTest {

    /**
     * 测试通过post 获取access_token
     */
    @Test
    public void getTest() throws URISyntaxException, IOException {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("github.com")
                .setPath("/login/oauth/access_token")
                .setParameter("client_id", "74713f7912b2c23addee")
                .setParameter("client_secret", "fec131ab85a0c87c10f1bbde234cc141512284c1")
                .setParameter("code", "9e7f4e20407149b9a453")
                .build();
        HttpPost httpPost = new HttpPost(uri);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if(entity != null){
           String result = EntityUtils.toString(entity);
            System.out.println(result);
        }
    }

    @Test
    public void getUserInfoByToken() throws URISyntaxException, IOException {
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("api.github.com")
                .setPath("user")
                .setParameter("access_token", "33fa118d8f0fbc30d7b536acb7d1da7028e5f52c")
                .build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity != null){
            String result = EntityUtils.toString(entity);
            System.out.println(result);
            ObjectMapper objectMapper = new ObjectMapper();
            //jackson 解析
            Map map = objectMapper.readValue(result, HashMap.class);
            System.out.println("======================");
        }
    }
}
