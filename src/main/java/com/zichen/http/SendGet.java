package com.zichen.http;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

public class SendGet {

    public static void main(String[] args) {
        String urlParam1 = "https://jiashubing.cn/talk/document?fileid=1234";
        String urlParam2 = "https://jiashubing.cn/talk/document/1234";
        sendGet(urlParam1);
    }

    public static String sendGet(String urlParam) {
        System.out.println("开始发起GET请求，请求地址为：" +  urlParam);
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(urlParam);
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        getMethod.addRequestHeader("Content-Type", "application/json");
        try {
            httpClient.executeMethod(getMethod);
            String result = getMethod.getResponseBodyAsString();
            getMethod.releaseConnection();
            System.out.println("返回信息为{}" + result);
            return result;
        } catch (IOException e) {
            System.out.println("GET请求发出失败，请求的地址为{}，错误信息为{}" + urlParam + e.getMessage() + e);
        }
        return null;
    }
}
