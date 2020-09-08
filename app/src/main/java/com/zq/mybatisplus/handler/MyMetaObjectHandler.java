package com.zq.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 填充策略,默认有值不覆盖,如果提供的值为null也不填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "createAt", LocalDateTime.now());
        this.fillStrategy(metaObject, "updateAt", LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateAt", LocalDateTime.now());
    }
}
