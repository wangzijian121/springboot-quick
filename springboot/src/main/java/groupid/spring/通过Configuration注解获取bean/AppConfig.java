package groupid.spring.通过Configuration注解获取bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Wang Zijian
 * @Date: 2024/5/21
 */
@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        MyBean obj = new MyBean("666");
        return obj;
    }
}
