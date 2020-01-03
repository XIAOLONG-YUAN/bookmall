package com.yuan.bookmall.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "yuan-order",fallback = RemoteHystrix.class)
public interface ProvideFeign {

    @GetMapping("/scTest/{string}")
    String test(@PathVariable("string") String string);
}
