package demo;

public class demo1 {
    public static void main(String[] args) {
        myRunable mr = new myRunable();
        Thread t1 = new Thread(mr,"飞机");
        Thread t2 = new Thread(mr,"tanke");

        int p = t1.getPriority();
        System.out.println(p);
        int r = t2.getPriority();
        System.out.println(r);
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}
