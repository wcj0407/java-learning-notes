package WAITNOtifyall;

public class Cook extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized(Dask.lock) {
                if(Dask.count==0) {
                    break;
                } else {
                    //如果桌子上没有食物
                    if (Dask.Foodflag==0) {
                        try {
                            Dask.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Dask.count--;
                        System.out.println("吃货正在吃面条还能吃"+Dask.count+"碗");
                        Dask.Foodflag=0;
                        Dask.lock.notifyAll();
                    }
            }
            }
        }
    }

}
