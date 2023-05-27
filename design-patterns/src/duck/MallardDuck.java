package duck;

import duck.impl.FlyWithWings;
import duck.impl.Quack;

public class MallardDuck extends Duck {


    public MallardDuck() {
        quackBehavior=new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void swim() {
        System.out.println("绿头鸭 游泳");

    }

    @Override
    public void display() {
        System.out.println("我是绿头鸭！");
    }


    public static void main(String[] args) {
        MallardDuck mallardDuck=new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}
