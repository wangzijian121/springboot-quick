package duck;

public class RedheadDuck extends Duck implements  Quackable{
    @Override
    public void quack() {
        System.out.println("红头鸭叫！");
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
