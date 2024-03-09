package 策略模式.impl;


import 策略模式.behavior.QuackBehavior;

public class Squack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱叫的鸭子！");
    }
}
