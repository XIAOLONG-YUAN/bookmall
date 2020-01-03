package com.yuan.bookmall.feign;

import org.springframework.stereotype.Component;

@Component
public class RemoteHystrix implements ProvideFeign {

    @Override
    public String test(String string) {
        return "请求超时了";
    }
}