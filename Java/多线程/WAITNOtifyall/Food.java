package WAITNOtifyall;

public class Food extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized (Dask.lock) {
                if (Dask.count==0) {
                    break;
                } else {
                    if (Dask.Foodflag==1) {
                        try {
                            Dask.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    } else {
                        System.out.println("厨师正在做面条");
                        Dask.Foodflag=1;
                        Dask.lock.notifyAll();
                    }
                }
            }
        }
    }
}
