package jvm内存模型;


public class DemoStr {
    public static void main(String[] args) throws InterruptedException {

        String name = "wangzijian";
        setStr(name);
        System.out.println(name);

        StringBuilder str2 = new StringBuilder();
        str2.append("123");
        setNewBuild(str2);
        System.out.println(str2);

    }


    public static void setStr(String name) {
        name = "wangzijian_new";
    }

    public static void setNewBuild(StringBuilder str) {
        str.append("newnewnewnewn!");
    }
}

