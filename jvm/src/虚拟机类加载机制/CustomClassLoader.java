package 虚拟机类加载机制;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

public class CustomClassLoader extends ClassLoader {


    /**
     *
     * @param name
     *         The <a href="#name">binary name</a> of the class
     *
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);

    }

}
