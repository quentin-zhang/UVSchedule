package com.uv.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uv.entity.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class AliESService {
    @Value("${bootstrap.epactiveurl}")
    private String url;
    @Value("${bootstrap.eppvurl}")
    private String eppvurl ;
    @Value("${bootstrap.epexurl}")
    private String epexurl ;
    @Value("${bootstrap.conditionurl}")
    private String conditionurl ;
    @Value("${bootstrap.userurl}")
    private String userurl ;
    @Value("${bootstrap.activeuserurl}")
    private String activeuserurl ;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    //获取活跃用户数
    public List<CPEPActiveUserCount>  getActiveUserCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.url);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        List<CPEPActiveUserCount> auCountList = gson.fromJson(result.toString(), new TypeToken<List<CPEPActiveUserCount>>() {
        }.getType());

        return auCountList;
    }

    //获取PV数
    public List<CPEPPVCount>  gePVCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.eppvurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        myMap.put("indexName", "cloudplus-clientpv-*");

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        List<CPEPPVCount> auCountList = gson.fromJson(result.toString(), new TypeToken<List<CPEPPVCount>>() {
        }.getType());
        return auCountList;
    }

    //获取异常数
    public List<CPEPExceptionCount>  getExceptionCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.epexurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        myMap.put("indexName", "cloudplus-exception-*");

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        List<CPEPExceptionCount> auCountList = gson.fromJson(result.toString(), new TypeToken<List<CPEPExceptionCount>>() {
        }.getType());

        return auCountList;
    }

    //获取超时异常数
    public ConditionCount  getTimeoutExceptionCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.conditionurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        myMap.put("indexName", "cloudplus-exception-*");
        myMap.put("timeKey", "happenTime");
        myMap.put("conditionKey", "errorCode.keyword");
        myMap.put("conditionValue", "-1001");

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ConditionCount auCountList = gson.fromJson(result.toString(), ConditionCount.class);

        return auCountList;
    }

    //获取用户与PV数详情
    public List<CPUserPV>   getCPUserPV(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.userurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        List<CPUserPV> auCountList = gson.fromJson(result.toString(), new TypeToken<List<CPUserPV>>() {
        }.getType());

        return auCountList;
    }

    /*获取昨日活跃用户数*/
    public int GetYesterdayActiveUserCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.activeuserurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        myMap.put("indexName", "cloudplus-clientpv-*");
        myMap.put("timeKey", "collectTime");
        myMap.put("conditionKey", "_type");
        myMap.put("conditionValue", "logs");

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ConditionCount auCount = gson.fromJson(result.toString(), ConditionCount.class);
        int auResult =Integer.parseInt( auCount.getTotal());
        return auResult;
    }

    /*获取昨日PV数*/
    public int GetYesterdayPVCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.conditionurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        myMap.put("indexName", "cloudplus-clientpv-*");
        myMap.put("timeKey", "collectTime");
        myMap.put("conditionKey", "_type");
        myMap.put("conditionValue", "logs");

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ConditionCount auCount = gson.fromJson(result.toString(), ConditionCount.class);
        int auResult =Integer.parseInt( auCount.getTotal());
        return auResult;
    }

    /*获取昨日异常数*/
    public int GetYesterdayExceptionCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(this.conditionurl);

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("startTime", startTime);
        myMap.put("endTime", endTime);
        myMap.put("indexName", "cloudplus-exception-*");
        myMap.put("timeKey", "happenTime");
        myMap.put("conditionKey", "_type");
        myMap.put("conditionValue", "logs");

        Gson gson = new Gson();
        String json = gson.toJson(myMap);
        StringEntity entity = new StringEntity(json);

        post.setEntity(entity);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        HttpResponse response = client.execute(post);
        logger.info("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ConditionCount auCount = gson.fromJson(result.toString(), ConditionCount.class);
        int auResult =Integer.parseInt( auCount.getTotal());
        return auResult;
    }
}
