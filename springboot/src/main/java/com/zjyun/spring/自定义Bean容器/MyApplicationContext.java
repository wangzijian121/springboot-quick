package com.zjyun.spring.自定义Bean容器;

import com.zjyun.spring.自定义Bean容器.bean.Bean1;
import com.zjyun.spring.自定义Bean容器.bean.Bean2;
import com.zjyun.spring.自定义Bean容器.bean.Bean3;
import com.zjyun.spring.自定义Bean容器.utils.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description: 自定义容器，并为容器中的BeanFactory和 bean手动配置后处理器。
 * @Author: Wang Zijian
 * @Date: 2024/5/27
 */
public class MyApplicationContext {

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("bean1", Bean1.class);
        context.registerBean("bean2", Bean2.class);
        context.registerBean("bean3", Bean3.class);
        context.refresh();
        //添加
        context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        context.registerBean(CommonAnnotationBeanPostProcessor.class);
        BeanFactoryUtils.printBeansDefinitionNames(context);
        System.out.println(context.getBean("bean1"));

    }
}
