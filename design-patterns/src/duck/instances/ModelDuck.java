package duck.instances;

import duck.impl.FlyNoWay;
import duck.impl.MuteQuack;
import duck.impl.RocketFly;

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
