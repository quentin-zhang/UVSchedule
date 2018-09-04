package com.uv.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.uv.entity.CPEPActiveUserCount;
import com.uv.entity.CPEPExceptionCount;
import com.uv.entity.CPEPPVCount;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    //获取活跃用户数
    public List<CPEPActiveUserCount>  getActiveUserCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

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
        System.out.println("Response Code : "
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

        System.out.println(auCountList);
        return auCountList;
    }

    //获取PV数
    public List<CPEPPVCount>  gePVCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(eppvurl);

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
        System.out.println("Response Code : "
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

        System.out.println(auCountList);
        return auCountList;
    }

    //获取异常数
    public List<CPEPExceptionCount>  getExceptionCount(String startTime, String endTime) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(epexurl);

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
        System.out.println("Response Code : "
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

        System.out.println(auCountList);
        return auCountList;
    }
}
