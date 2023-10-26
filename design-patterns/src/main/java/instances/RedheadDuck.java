package instances;


import impl.FlyWithWings;
import impl.Quack;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        flyBehavior=new FlyWithWings();
        quackBehavior=new Quack();

    }

    @Override
    public void swim() {
        System.out.println("红头鸭游泳！");
    }



    @Override
    public void display() {
        System.out.println("我是红头鸭！");
    }


}
