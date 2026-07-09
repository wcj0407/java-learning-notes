package Mycallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        mycallable mc = new mycallable();
        //FutureTask用来管理多线程的结果的
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        //没有这一步就没有在控制台中显示出答案
        Integer i = ft.get();
        System.out.println(i);
    }
}
