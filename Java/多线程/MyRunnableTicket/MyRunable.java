package MyRunnableTicket;

public class MyRunable implements Runnable{


    int ticket=0;

    @Override
    public void run() {
        while(true){

                if (extracted()) break;

        }

    }

    private synchronized boolean extracted() {
        if(ticket==100){
            return true;
        } else {
            ticket++;
            System.out.println(Thread.currentThread().getName()+"现在正在卖"+ticket+"票");
        }
        return false;
    }
}
