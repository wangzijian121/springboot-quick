package duck;

public class MallardDuck extends Duck {


    @Override
    public void quack() {
        System.out.println("绿头鸭-嘎嘎叫！");
    }

    @Override
    public void swim() {
        System.out.println("绿头鸭 游泳");

    }



    @Override
    public void display() {
        System.out.println("我是绿头鸭！");
    }
}
