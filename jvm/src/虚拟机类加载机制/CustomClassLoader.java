package 虚拟机类加载机制;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class CustomClassLoader extends ClassLoader {

    public Class findClass(String name) {

        byte[] b = loadClassData(name);
        //defineClass将定义字节数组转为对象
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {

        //从连接加载类数据
        //将我自己要加载的jar包转为byte数组返回
        //将指定目录下的.class文件 以文件的形式加载进来
        String className = name.replace(".", "\\") + ".class";
        //我这里使用了自己的本地路径.
        File file = new File("C:\\Users\\Administrator\\Desktop\\JVM\\out\\production\\JVM\\虚拟机类加载机制\\" + className);
        System.out.println("file:"+file);
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int b = 0;
            while((b = fileInputStream.read()) != -1) {
                byteArrayOutputStream.write(b);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (byteArrayOutputStream != null) {

                    byteArrayOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader customClassLoader = new CustomClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(customClassLoader.getClass().getClassLoader());
        //sun.misc.Launcher$ExtClassLoader@7f31245a
        System.out.println(customClassLoader.getClass().getClassLoader().getParent());
        //null
        System.out.println(customClassLoader.getClass().getClassLoader().getParent().getParent());

        Class c = customClassLoader.loadClass("com.zjyun.MyInfo");
        //System.out.println("ClassName:" + c.getClass().getName());

    }
}

