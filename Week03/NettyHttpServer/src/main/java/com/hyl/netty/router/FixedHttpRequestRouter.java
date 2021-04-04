package com.hyl.netty.router;

public class FixedHttpRequestRouter implements HttpRequestRouter{
    @Override
    public String route() {
        String url = "http://localhost:8801";
        return url;
    }
}
