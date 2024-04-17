package 单例模式.饿汉式单例模式;

import java.io.Serializable;

/**
 * 饿汉式单例
 *
 * @author zijian Wang
 * <p>
 * 问题1：为什么加 final: 防止子类继承。
 * <p>
 */

/**
 *  问题2：如果实现了序列化接口, 还要做什么来防止反序列化破坏单例 ：readResolve
 *
 * */

public final class Singleton implements Serializable {

    /**  问题3：为什么设置为私有? 是否能防止反射创建新的实例?*/
    /** 问题4：这样初始化是否能保证单例对象创建时的线程安全?*/
    private static final Singleton singleton = new Singleton();

    public Singleton() {
    }

    /** 问题5：为什么提供静态方法而不是直接将 INSTANCE 设置为 public, 说出你知道的理由: 封装思想，防止其他类通过public修改。*/
    public static Singleton getInstance() {
        return singleton;
    }

    public Object readResolve() {
        return singleton;
    }

}
