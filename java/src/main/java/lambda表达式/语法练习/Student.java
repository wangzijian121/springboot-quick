package lambda表达式.语法练习;

/**
 * @author zijian Wang
 */
public class Student implements  Say{
    @Override
    public String say(String name) {
        return "我的名字是："+name;
    }
}
