package 异常.自定义异常;

/**
 * 自定义异常
 * @author zijian Wang
 */
public class Demo {
    public static void main(String[] args) throws MyException {

//        throw new NumberFormatException("wangzijian");
//        throw new MyException("wangzijian");

        throw  MyException.forInputString ("wangzijian");

    }
}
