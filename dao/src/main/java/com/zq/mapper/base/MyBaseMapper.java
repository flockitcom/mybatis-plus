package com.zq.mapper.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

public interface MyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 物理删除
     */
    int deleteReal(@Param(Constants.WRAPPER) Wrapper<T> wrapper);

    /**
     * 逻辑删除并填充
     * @param t
     */
    int deleteByIdWithFill(T t);
}
