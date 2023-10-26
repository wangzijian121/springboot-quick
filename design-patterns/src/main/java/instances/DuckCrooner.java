package instances;


import behavior.QuackBehavior;
import impl.Quack;

/**
 * 鸭鸣器，不属于鸭子。
 */
public class DuckCrooner {

    //叫
    QuackBehavior quackBehavior = new Quack();

    public void quack() {
        quackBehavior.quack();
    }

    public static void main(String[] args) {
        DuckCrooner duckCrooner=new DuckCrooner();
        duckCrooner.quack();
    }
}
