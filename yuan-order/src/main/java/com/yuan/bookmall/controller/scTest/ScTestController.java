package com.yuan.bookmall.controller.scTest;


import lombok.extern.java.Log;
import org.slf4j.Logger;
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
@Log
public class ScTestController {

    @GetMapping("/{string}")
    public String test(@PathVariable("string") String string) {
        log.info("invoke");
        return "Hello Nacos :" + string;
    }

}

