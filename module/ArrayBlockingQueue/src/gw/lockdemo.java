package gw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockdemo {
    static  int i ;
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(new Add(lock)).start();
        new Thread(new Add(lock)).start();

        Thread.sleep(5000);
        System.out.println(i);
    }

}
class Add implements Runnable {
    private final Lock lock;


    public Add(Lock lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++)
        {
                lock.lock();
                lockdemo.i++;
                lock.unlock();
        }
        }
    }






