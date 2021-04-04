package com.hyl.netty.filter;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;

import java.io.UnsupportedEncodingException;

public class BodyHttpResponseFilter implements HttpResponseFilter {

    @Override
    public FullHttpResponse filter(String url, FullHttpResponse response) {
        response = (DefaultFullHttpResponse)response;
        FullHttpResponse newResponse = null;
        String finalResponse = url + "/Response filter";
        try {
            newResponse = response.replace(Unpooled.wrappedBuffer(finalResponse.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newResponse;
    }
}
