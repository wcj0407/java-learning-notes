package Mysynchronized;

public class MyThread extends Thread{
    static int ticket=0;
    static Object lock=new Object();
    @Override
    public void run() {
        while(true){
           synchronized (lock) {
               if (ticket<100) {
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   ticket++;
                   System.out.println(getName()+"现在正在买"+ticket+"的票");
               } else {
                   System.out.println("买完了");
                   break;
               }
           }
        }
    }
}
