package 虚拟机类加载机制;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader3 extends ClassLoader {

    private String classPath;

    public CustomClassLoader3(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] data = loadClassData(name);
        if (data != null) {
            return defineClass(name, data, 0, data.length);
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] loadClassData(String name) {
        String fileName = classPath + name.replace('.', '/') + ".class";
        System.out.println("Loading class " + name + " from " + fileName);
        try {
            InputStream is = new FileInputStream(fileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            is.close();
            bos.close();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CustomClassLoader3 customClassLoader3=new CustomClassLoader3("D:\\tmp\\test\\");

        System.out.println(customClassLoader3);
    }
}
