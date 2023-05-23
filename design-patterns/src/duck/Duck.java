package duck;

public abstract class Duck {

    //鸭子叫
    public void quack() {
        System.out.println("鸭子默认嘎嘎叫！");
    }

    //游泳
    public void swim() {
        System.out.println("鸭子默认游泳！");
    }



    //display
    public abstract void display();

}
