package groupid.spring.通过xml获取bean;

/**
 * @Description:
 * @Author: Wang Zijian
 * @Date: 2024/5/20
 */

public class MyBean {
    private String name = "wangzijian";

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public MyBean() {
    }

    public MyBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
