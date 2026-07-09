package thread1;

public class Test {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t2.setName("t2");
        t1.setName("t1");
        t1.start();
        t2.start();
    }
}
