package duck.impl;

import duck.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("展翅飞！");
    }
}
