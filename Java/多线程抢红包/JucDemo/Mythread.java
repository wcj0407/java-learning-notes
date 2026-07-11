package JucDemo;

import java.util.Random;

public class Mythread extends Thread {
    static double money = 100;
    static int count = 3;
    static Random r = new Random();

    @Override
    public void run() {
        synchronized (Mythread.class) {
            if (count == 0) {
                System.out.println(getName()+"抢完了");
            } else {
                double prize = 0;
                if (count == 1) {
                    // 最后一个人拿走全部剩余
                    prize = money;
                } else {
                    // 动态上限，保证至少剩0.02给后面的人
                    double bounds = money - 0.02;
                    prize = r.nextDouble(bounds);
                    // 最少抢0.01
                    if (prize < 0.01) {
                        prize = 0.01;
                    }
                }
                // 先打印抢到的金额，再扣钱、减少红包数
                System.out.println(getName() + "抢到了" + prize + "元");
                money = money - prize;
                count--;
            }
        }
    }
}