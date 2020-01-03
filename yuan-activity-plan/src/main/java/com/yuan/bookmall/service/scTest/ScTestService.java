package com.yuan.bookmall.service.scTest;

import com.yuan.bookmall.pojo.scTest.ScTest;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxl
 * @since 2020-01-02
 */
public interface ScTestService extends IService<ScTest> {

}
