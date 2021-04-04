package com.hyl.netty.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {

    FullHttpResponse filter(String url, FullHttpResponse response);

}
