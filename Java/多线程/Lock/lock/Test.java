package lock;

public class Test {
    public static void main(String[] args) {
     Mylock t1 = new Mylock();
     Mylock t2 = new Mylock();
     Mylock t3 = new Mylock();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
