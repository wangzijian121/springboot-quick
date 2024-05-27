package com.zjyun.spring.自定义Bean容器.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Wang Zijian
 * @Date: 2024/5/27
 */
@Component
public class Bean1 {
    @Autowired
    private Bean2 bean2;
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bean1(Bean2 bean2) {
        this.bean2 = bean2;
    }

    @Override
    public String toString() {
        return "Bean1{" +
                "bean2=" + bean2 +
                ", name='" + name + '\'' +
                '}';
    }
}
2