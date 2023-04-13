package 虚拟机类加载机制;

/**
 * 破坏双亲委派模型 的自定义类加载器
 */

import com.zjyun.MyInfo;

import java.io.*;


public class CustomClassLoader2 extends ClassLoader {



    public static ClassLoader getClassLoader(Class<?> caller) {

        System.out.println("CustomClassLoader2");
        return null;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        byte[] b = loadClassData(name);
        if (b == null) {
            return super.loadClass(name);
        }

        //defineClass将定义字节数组转为对象
        return defineClass(name, b, 0, b.length);
    }

    //从连接加载类数据
    private byte[] loadClassData(String name) throws ClassNotFoundException {

        //将指定目录下的.class文件 以文件的形式加载进来
        String className = name.replace(".", "\\") + ".class";
        //将我自己要加载的jar包转为byte数组返回, 我这里使用了自己的本地路径.
        String fileName = "D:\\tmp\\test\\" + className;

        System.out.println("file:" + fileName);
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = getClass().getResourceAsStream(fileName);

            if (inputStream == null) {
                return null;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println(System.getProperty("java.class.path").replace(";","\n"));

        CustomClassLoader2 customClassLoader = new CustomClassLoader2();

        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(customClassLoader.getClass().getClassLoader());
        //sun.misc.Launcher$ExtClassLoader@7f31245a
        System.out.println(customClassLoader.getClass().getClassLoader().getParent());
        //null
        System.out.println(customClassLoader.getClass().getClassLoader().getParent().getParent());

        Class<?> c = customClassLoader.loadClass("com.zjyun.MyInfo");
        ClassLoader classLoader = c.getClassLoader();
        System.out.println("MyInfo ClassLoader: " + classLoader);
        System.out.println("Is CustomClassLoader2 loaded MyInfo? " + (classLoader == customClassLoader));
        try {
            MyInfo myInfo = (MyInfo) c.newInstance();
            //MyInfo 信息
            System.out.println("myInfo:" + myInfo);
            //看看MyInfo这个类的ClassLoader是谁？

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}