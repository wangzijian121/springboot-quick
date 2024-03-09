package 策略模式.impl;


import 策略模式.behavior.QuackBehavior;

public class MuteQuack  implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫的鸭子！");
    }
}
