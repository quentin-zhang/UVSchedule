package com.uv.services;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PVService {
    @Value("${bootstrap.epactiveurl}")
    private String url = "https://uvc1.inspuronline.com/enterprise/activeusers";

    public void Send() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        // add header
//        post.setHeader("User-Agent", USER_AGENT);
        String json = "{\"startTime\":\"2018-08-01 08:12:14\",\"endTime\":\"2018-08-30 08:14:14\"}";
        StringEntity entity = new StringEntity(json);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("startTime", "2018-08-01 08:12:14"));
        urlParameters.add(new BasicNameValuePair("endTime", "2018-08-30 08:14:14"));
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
        System.out.println(result);
    }
}
