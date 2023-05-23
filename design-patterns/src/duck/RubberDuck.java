package duck;

public class RubberDuck extends Duck implements Quackable{
    @Override
    public void quack() {
        System.out.println("橡皮鸭吱吱响！");
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

