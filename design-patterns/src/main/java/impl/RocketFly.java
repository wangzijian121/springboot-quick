package impl;


import behavior.FlyBehavior;

public class RocketFly  implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("使用火箭飞行！");
    }
}
