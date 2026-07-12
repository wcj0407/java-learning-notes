package xianchengci;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyEx {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程
                6,//线程池中最多可以创建的对象
                60,//空闲时间
                TimeUnit.SECONDS,//空闲时间的单位
                new ArrayBlockingQueue<>(3),//阻塞队列的长度
                new ThreadPoolExecutor.AbortPolicy());//策略


    }
}
