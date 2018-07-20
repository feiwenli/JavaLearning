package com.hand;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Post extends Thread{
    HttpClient client = HttpClients.createDefault();

    @Override
    public void run(){
        HttpPost post = new HttpPost("http://fanyi.youdao.com/openapi.do");

        try {
            List<BasicNameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair("keyfrom","JKXY-test"));
            parameters.add(new BasicNameValuePair("key","343166845"));
            parameters.add(new BasicNameValuePair("type","data"));
            parameters.add(new BasicNameValuePair("doctype","xml"));
            parameters.add(new BasicNameValuePair("version","1.1"));
            parameters.add(new BasicNameValuePair("q","welcome"));


            post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity,"UTF-8");
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class HTTPClientsPostDemo {
    public static void main(String [] args){
        new Post().start();
    }
}
