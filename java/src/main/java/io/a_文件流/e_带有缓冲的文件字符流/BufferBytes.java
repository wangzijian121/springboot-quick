package io.d_带有缓冲的字节流.e_带有缓冲的字符流;

import java.io.*;

/**
 * 使用带有缓冲的字符流
 *
 * @author zijian Wang
 */
public class BufferBytes {
    public static void main(String[] args) throws IOException, InterruptedException {
        String outputPath = "java/target/classes/io/output.txt";
        BufferedOutputStream bufferedOutputStream = null;
        try {

            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputPath));
            bufferedOutputStream.write("buffer_bytes".getBytes());
        } finally {
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }
    }

}
