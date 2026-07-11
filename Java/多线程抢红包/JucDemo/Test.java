package JucDemo;

public class Test {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();
        Mythread t3 = new Mythread();
        Mythread t4 = new Mythread();
        Mythread t5 = new Mythread();

        t1.setName("a");
        t2.setName("b");
        t3.setName("c");
        t4.setName("d");
        t5.setName("e");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
