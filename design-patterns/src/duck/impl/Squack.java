package duck.impl;

import duck.QuackBehavior;

public class Squack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱叫的鸭子！");
    }
}
