package 数据类型;

/**
 * @author zijian Wang
 */
public class Demo1 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Demo1 get(Demo1 d) {
        d.name = "getgetget";
        return d;
    }
}

class Run {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
//        System.out.println(demo1.name);//无法访问
        System.out.println(demo1.getName());//可以访问到
    }
}