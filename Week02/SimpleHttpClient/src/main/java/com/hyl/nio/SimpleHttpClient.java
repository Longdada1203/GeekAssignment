package com.hyl.nio;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SimpleHttpClient {
    public static void main(String[] args) throws IOException {
        //Create HttpClient Instance
        HttpClient httpClient = new DefaultHttpClient();

        //Cteate Get function
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8801");
        HttpResponse response = httpClient.execute(httpGet);

        //Parse response
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream in = entity.getContent();
            String body = convertStreamtoString(in);
            System.out.println("----------------result---------------");
            System.out.println(body);
            System.out.println("----------------result---------------");
        }
    }

    private static String convertStreamtoString(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (sb.toString().length() != 0){
                sb.append("\n" + line);
                continue;
            }
            sb.append( line);
        }
        in.close();
        return sb.toString();
    }
}
