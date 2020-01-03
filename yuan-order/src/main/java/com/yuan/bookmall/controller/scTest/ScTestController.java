package com.yuan.bookmall.controller.scTest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxl
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/scTest")
public class ScTestController {

    @GetMapping("/{string}")
    public String test(@PathVariable("string") String string) {
        return "Hello Nacos :" + string;
    }

}

