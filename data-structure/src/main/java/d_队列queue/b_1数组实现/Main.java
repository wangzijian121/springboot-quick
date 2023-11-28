package d_队列queue.b_1数组实现;

import java.util.Scanner;

/**
 *
 * @author zijian Wang
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);

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
                        arrayQueue.add(scanner.next());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    arrayQueue.consume();
                    break;
                case 3:
                    arrayQueue.removeAll();
                    break;
                case 4:
                    arrayQueue.show();
                    break;
                default:
                    System.out.println("请重新输入🙄");
                    break;
            }
        }
    }
}
