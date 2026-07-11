package WAITNOtifyall;

public class Test {
    public static void main(String[] args) {
        Cook c = new Cook();
        Food f = new Food();
        c.setName("厨师");
        f.setName("吃货");
        c.start();
        f.start();
    }
}
