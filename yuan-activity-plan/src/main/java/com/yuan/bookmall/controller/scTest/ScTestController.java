package com.yuan.bookmall.controller.scTest;


import com.yuan.bookmall.feign.ProvideFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxl
 * @since 2020-01-02
 */
@RestController
@RequestMapping("/scTest")
public class ScTestController {

    @Autowired
    ProvideFeign provideFeign;

    @GetMapping("/test")
    public String test() {
        String test = provideFeign.test("nihao");
        return test;
    }

}

