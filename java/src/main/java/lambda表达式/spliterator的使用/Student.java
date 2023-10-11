package lambda表达式.spliterator的使用;

/**
 * @author zijian Wang
 */
public class Student {
    private  Integer age;

    public Student(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
