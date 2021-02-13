package cocurrent.java.communication.pipe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.stream.Collectors;

public class Reader implements Runnable{

    private PipedInputStream pipedInputStream;


    public Reader(PipedInputStream pipedInputStream){
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        if (pipedInputStream != null) {
            String collect = new BufferedReader(new InputStreamReader(pipedInputStream)).lines().collect(
                    Collectors.joining("\n")
            );
            System.out.println(collect + " " + Thread.currentThread().getName());
        }
        try {
            pipedInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
