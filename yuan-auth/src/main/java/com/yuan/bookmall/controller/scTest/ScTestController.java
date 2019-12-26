package com.yuan.bookmall.controller.scTest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.bookmall.pojo.scTest.ScTest;
import com.yuan.bookmall.service.scTest.ScTestService;
import common.ServerResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxl
 * @since 2019-12-26
 */
@RestController
@RequestMapping("/scTest")
public class ScTestController {
    @Autowired
    ScTestService scTestService;

    @ApiOperation(value = "查询",notes = "查询",produces =MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "select")
    public ServerResponse select(
            @ApiParam(value = "当前页码") @RequestParam(value = "currentPage", required = false,defaultValue="1") Integer currentPage,
            @ApiParam(value = "每页数量") @RequestParam(value = "pageSize", required = false,defaultValue="10") Integer pageSize,
            @ApiParam(value = "根据用户的名称模糊查询") @RequestParam(value = "Condition", required = false) String Condition){
        Page page = new Page(currentPage,pageSize);
        QueryWrapper<ScTest> qw = new QueryWrapper<>();
        qw.eq(StringUtils.isNotEmpty(Condition), "SC_NAME", Condition).orderByAsc("SC_OPERATOR_TIME");
        IPage page1 = scTestService.page(page,qw);
        return ServerResponse.createSuccess(page1);

    }

}

