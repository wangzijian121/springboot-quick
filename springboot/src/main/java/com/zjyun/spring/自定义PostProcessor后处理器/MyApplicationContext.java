package com.zjyun.spring.自定义PostProcessor后处理器;

import com.zjyun.spring.自定义PostProcessor后处理器.bean.Bean1;
import com.zjyun.spring.自定义PostProcessor后处理器.bean.Bean2;
import com.zjyun.spring.自定义PostProcessor后处理器.bean.Bean3;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 自定义PostProcessor 后处理器，分析底层实现原理。
 * @Author: Wang Zijian
 * @Date: 2024/5/27
 */
public class MyApplicationContext {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton("bean2",new Bean2());
        beanFactory.registerSingleton("bean3",new Bean3());

        //封装方法代码
        //context.registerBean(AutowiredAnnotationBeanPostProcessor.class);
        AutowiredAnnotationBeanPostProcessor processor = new AutowiredAnnotationBeanPostProcessor();
        processor.setBeanFactory(beanFactory);

        //为了演示没有依赖关系
        Bean1 bean1=new Bean1();
        System.out.println(bean1);//Bean1{bean2=null, name='null'}
        //封装方法代码
        //执行后处理操作,将bean实例化，并解析@Autowired、@Value注解的解析
//        processor.postProcessProperties(null,bean1,"bean1");
//        System.out.println(bean1);//Bean1{bean2=com.zjyun.spring.自定义PostProcessor后处理器.bean.Bean2@5dfcfece, name='null'}
        try {
            //通过反射获取findAutowiringMetadata 方法。
            Method objectMethod = AutowiredAnnotationBeanPostProcessor.class.getDeclaredMethod("findAutowiringMetadata",
                    String.class,
                    Class.class,
                    PropertyValues.class);
            objectMethod.setAccessible(true);
            InjectionMetadata metadata = (InjectionMetadata) objectMethod.invoke(processor, "bean1", Bean1.class, null);
            metadata.inject(bean1, "bean1", null);

            //inject 内部原理
            //获取字段依赖
            Field bean2 = Bean1.class.getDeclaredField("bean2");
            DependencyDescriptor dependencyDescriptor =new DependencyDescriptor(bean2,false);
            Object o = beanFactory.doResolveDependency(dependencyDescriptor, null, null, null);
            System.out.println("inject内部原理-依赖的对象："+o);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println(bean1);
    }
}
