package com.example.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

/**
 * 引入依赖
 * <dependency>
 *      <groupId>org.apache.httpcomponents</groupId>
 *      <artifactId>httpclient</artifactId>
 *      <version>4.5.13</version>
 * </dependency>
 */

public class HttpClient {
    public static void main(String[] args) {
        //获取http客户端
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        //创建get请求
        HttpGet httpGet = new HttpGet("http://localhost:8801/");
        //响应模型
        CloseableHttpResponse response = null;
        try{
            //执行请求
            response = closeableHttpClient.execute(httpGet);
            //获取实体
            HttpEntity entity = response.getEntity();
            //输出状态
            System.out.println("状态码:"+response.getStatusLine());
            //输出内容
            if (entity!=null){
                System.out.println("响应内容:"+ EntityUtils.toString(entity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
