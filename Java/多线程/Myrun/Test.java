package Myrun;

public class Test {
    public static void main(String[] args) {
        myrun mr = new myrun();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.setName("1");
        t2.setName("2");
        t1.start();
        t2.start();
    }
}
