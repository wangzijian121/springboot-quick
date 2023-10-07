package 自动装拆箱;

public class Demo {
    private Integer i;
    private int j;
    private  long num=100_000;

    public void print() {
        j = i;
        System.out.println(i);
        System.out.println(j);
    }

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.print();

    }
}
