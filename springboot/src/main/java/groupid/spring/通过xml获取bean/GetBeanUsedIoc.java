package groupid.spring.通过xml获取bean;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: Wang Zijian
 * @Date: 2024/5/20
 */
public class GetBeanUsedIoc {
    public static void main(String[] args) {
        // 使用 XML 配置文件,获取当前类路径,读取当前类路径中的applicationContext.xml配置文件
        //1.构造ClassPathXmlApplicationContext实例
        // 2.调用refresh 方法，内部调用refreshBeanFactory
        // 3.loadBeanDefinitions  加载配置文件（applicationContext.xml）中的bean信息。
        //4.ClassPathXmlApplicationContext 继承自 AbstractXmlApplicationContext，而后者最终继承自 DefaultResourceLoader，它实现了 ResourceLoader 接口。
        //5.ResourceLoader 接口提供了 getResource 方法，用于加载资源文件。ClassPathXmlApplicationContext 会调用这个方法来加载配置文件。

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        System.out.println("当前类路径："+System.getProperty("java.class.path"));
//        System.out.println("Classpath：" + System.getenv());
//        System.getenv().keySet().forEach(x -> System.out.println(x+": " + System.getenv().get(x)));
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"WEB-INF/applicationContext.xml"}, MyBean.class, null);

        MyBean myBean = (MyBean) context.getBean("MyBean");
        System.out.println(myBean);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("Bean name: " + beanName + ", Bean type: " + bean.getClass().getName());
        }
    }
}
