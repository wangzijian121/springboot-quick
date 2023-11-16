package a_数组array.数组;

/**
 * @author zijian Wang
 */
public class MyArray {

    private int[] arr;

    public MyArray(int size) {
        arr = new int[size];
    }

    public int get(int index) {
        return arr[index];
    }

    public void delete(int index) {
        //删除后，后面的元素往前移1位
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public void insert(int num, int index) {

        //插入元素位置往后移动1位
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = num;
    }

    public int indexOf(int num) {
        //遍历值返回索引
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void main(String[] args) {

        //指定长度的数组
        int[] nums = new int[5];
        MyArray myArray = new MyArray(5);
        myArray.insert(111, 0);
        myArray.insert(333, 1);
        myArray.insert(444, 3);
        myArray.insert(555, 4);
        myArray.insert(666, 4);
        myArray.print();
        System.out.println("\n获取第4个元素:" + myArray.get(4));
        myArray.delete(1);
        myArray.print();

        System.out.println("\n898的索引（应该没有） ：" + myArray.indexOf(898));
        System.out.println("\n666的索引（应该有） ：" + myArray.indexOf(666));
    }
}
