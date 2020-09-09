package com.zq.mybatisplus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;

import com.zq.mapper.base.DeleteRealMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        //要调用super,这样才能使用父类的方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new DeleteRealMethod());//自定义删除
        methodList.add(new LogicDeleteByIdWithFill());//逻辑删除并自动填充
        return methodList;
    }
}
