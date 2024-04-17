package 单例模式.枚举单例模式;

/**
 * 枚举单例类
 */
public enum SingletonEnum {

    INSTANCE;

    /**
     * 可以在枚举中添加其他成员变量和方法
     */
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

class SingletonEnumTest {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        instance.setValue(1);
        System.out.println(instance.getValue());
    }
}
