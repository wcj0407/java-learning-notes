package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mylock extends Thread{
    static Lock lock = new ReentrantLock();
    static int ticket =0;
    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if (ticket==100) {
                    break;
                } else {
                    ticket++;
                        Thread.sleep(10);
                    }
                System.out.println(Thread.currentThread().getName()+"在卖"+ticket+"票");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }


        }
    }


}
