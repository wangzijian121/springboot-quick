package 异常.自定义异常;

/**
 * @author zijian Wang
 */
public class MyException extends  Exception{

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public MyException() {
        super();
    }

    public MyException (String s) {
        super (s);
    }

    static MyException forInputString(String s) {
        return new MyException("this is MyException: \"" + s + "\"");
    }

}
