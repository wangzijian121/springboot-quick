package c_手写循环队列;

import java.util.Scanner;

/**
 * @author zijian Wang
 */
public class Main {
    public static void main(String[] args) {

        RingQueue ringQueue = new RingQueue(5);
        ringQueue.add(1);
        ringQueue.add(2);
        ringQueue.add(3);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入操作数：");
            System.out.println("1.add");
            System.out.println("2.consume");
            System.out.println("3.removeAll");
            System.out.println("4.show");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请输入add的数据：");
                    try {
                        ringQueue.add(scanner.next());
                        ringQueue.show();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    ringQueue.consume();
                    ringQueue.show();
                    break;
                case 3:
                    ringQueue.removeAll();
                    ringQueue.show();
                    break;
                case 4:
                    ringQueue.show();
                    break;
                default:
                    System.out.println("请重新输入🙄");
                    break;
            }
        }
    }
}
