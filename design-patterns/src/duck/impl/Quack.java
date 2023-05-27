package duck.impl;

import duck.QuackBehavior;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("鸭子嘎嘎叫！");
    }
}
