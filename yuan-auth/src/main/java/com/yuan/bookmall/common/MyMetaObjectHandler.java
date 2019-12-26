
package com.yuan.bookmall.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("ionDelFlag", "0", metaObject);
        this.setFieldValByName("ionOperateTime", LocalDateTime.now(ZoneId.of("+08:00")), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("ionOperateTime", LocalDateTime.now(ZoneId.of("+08:00")), metaObject);
    }
}

