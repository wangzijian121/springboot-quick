package 策略模式.instances;


import 策略模式.impl.FlyNoWay;
import 策略模式.impl.MuteQuack;

/**
 * 假鸭子类
 */
public class DecoyDuck extends Duck {

    public DecoyDuck() {
        flyBehavior=new FlyNoWay();
        quackBehavior=new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是个假鸭子");
    }


    @Override
    public void swim() {
        System.out.println("游泳");
    }


}
