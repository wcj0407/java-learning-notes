package Mycallable;

import java.util.concurrent.Callable;
//泛型是来接收call结果的对象类型
public class mycallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
        }
        return sum;
    }
}
