package 策略模式.impl;


import 策略模式.behavior.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("展翅飞！");
    }
}
