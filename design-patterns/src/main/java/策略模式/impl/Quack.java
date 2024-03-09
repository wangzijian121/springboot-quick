package 策略模式.impl;


import 策略模式.behavior.QuackBehavior;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("鸭子嘎嘎叫！");
    }
}
