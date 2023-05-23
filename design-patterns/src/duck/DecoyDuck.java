package duck;

/**
 * 假鸭子类
 */
public class DecoyDuck extends Duck {


    @Override
    public void display() {
        System.out.println("我是个假鸭子");
    }


    @Override
    public void quack() {
        //no action
    }

    @Override
    public void swim() {
        System.out.println("橡皮鸭游泳");
    }

    @Override
    public void fly() {
        //no action
    }


}
