package xianchengci;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class xianchenci1 {
    public static void main(String[] args) {
        //ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool1 = Executors.newFixedThreadPool(2);
        pool1.submit(new MyRunable());
        pool1.submit(new MyRunable()); pool1.submit(new MyRunable());
        pool1.submit(new MyRunable());
    }
}
