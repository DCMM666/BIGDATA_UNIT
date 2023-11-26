package gw;
public class lock {
       static  int i ;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new add()).start();
        new Thread(new add()).start();

        Thread.sleep(5000);
        System.out.println(i);
    }

}
class add implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++)
        {
            synchronized (lock.class)
            {
                lock.i++;
            }
        }
    }
}


class  A{

}
