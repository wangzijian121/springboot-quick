package duck;

public class RubberDuck extends Duck {
    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱响！");
    }

    @Override
    public void swim() {

        System.out.println("橡皮鸭游泳");
    }

    @Override
    public void fly() {

        System.out.println("橡皮鸭在飞！??? are you kidding me???");
    }

    @Override
    public void display() {
        System.out.println("我是个橡皮鸭!");
    }

    public static void main(String[] args) {
        RubberDuck rubberDuck = new RubberDuck();
        rubberDuck.fly();
    }

}

