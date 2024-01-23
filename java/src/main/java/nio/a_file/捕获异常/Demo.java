package nio.a_file.捕获异常;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 模拟文件异常
 *
 * @author zijian Wang
 */
public class Demo {
    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\dakjhwdlkajlwd.txt"))) {
            reader.readLine();
        } catch (IOException x) {
            //IOException: java.nio.file.NoSuchFileException: D:\dakjhwdlkajlwd.txt
            System.err.format("IOException: %s%n", x);
        }
    }
}
