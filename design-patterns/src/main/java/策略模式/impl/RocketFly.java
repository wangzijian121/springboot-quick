package 策略模式.impl;


import 策略模式.behavior.FlyBehavior;

public class RocketFly  implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("使用火箭飞行！");
    }
}
