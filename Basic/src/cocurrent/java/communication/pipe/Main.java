package cocurrent.java.communication.pipe;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 线程间通过管道进行通信
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedOutputStream.connect(pipedInputStream);

        //另一个线程进行输出
        new Thread(new Reader(pipedInputStream)).start();

            BufferedReader bufferedReader = null;

            // 获取控制台输入
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                pipedOutputStream.write(bufferedReader.readLine().getBytes(StandardCharsets.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pipedOutputStream.close();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
    }
}
