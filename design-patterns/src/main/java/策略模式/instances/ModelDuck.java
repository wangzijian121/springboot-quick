package 策略模式.instances;


import 策略模式.impl.FlyNoWay;
import 策略模式.impl.MuteQuack;
import 策略模式.impl.RocketFly;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是一个模型鸭！");
    }

    public static void main(String[] args) {
        ModelDuck modelDuck =new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new RocketFly());
        modelDuck.performFly();
    }

}
