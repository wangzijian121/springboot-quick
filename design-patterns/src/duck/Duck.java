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

    //fly
    //
    public void fly() {
        /**
         * 对代码的局部更改，导致了非局部的变化（例如，有的鸭子不会飞）{@link  RubberDuck#fly()}
         */
        System.out.println("鸭子默认的飞！");

    }

    //display
    public abstract void display();

}
