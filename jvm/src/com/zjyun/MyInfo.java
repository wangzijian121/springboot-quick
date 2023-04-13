package com.zjyun;

public class MyInfo {

    private String name = "wangzijian";
    private Integer age = 20;

    public MyInfo() {
    }

    public MyInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello World!!");
    }

    public static void sayStaticHello() {
        System.out.println("HELLO WORLD!!");
    }

    public static void main(String[] args) {

    }


    @Override
    public String toString() {
        return "MyInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
