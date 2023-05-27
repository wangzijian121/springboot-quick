package duck.instances;

import duck.impl.FlyNoWay;
import duck.impl.Squack;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior=new FlyNoWay();
        quackBehavior=new Squack();
    }

    @Override
    public void swim() {
        System.out.println("橡皮鸭游泳");
    }

    @Override
    public void display() {
        System.out.println("我是个橡皮鸭!");
    }

}

