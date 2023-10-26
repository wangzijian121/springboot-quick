package impl;


import behavior.QuackBehavior;

public class Squack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱叫的鸭子！");
    }
}
