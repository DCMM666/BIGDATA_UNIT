package lock_UNIT;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fairlockdemo {
    static int i=100;
    public static void main(String[] args) {
        Lock Fairlocklock = new ReentrantLock();
        new Thread(new add1(Fairlocklock)).start();
        new Thread(new add1(Fairlocklock)).start();
        new Thread(new add1(Fairlocklock)).start();
        new Thread(new add1(Fairlocklock)).start();

    }
}
class add1 implements Runnable {
    private final Lock lock;

    public add1(Lock lock) {
        this.lock =lock;
    }


    @Override
    public void run() {
        while (Fairlockdemo.i>0){
            lock.lock();
            Fairlockdemo.i--;
            System.out.println(Thread.currentThread().getName());
            lock.unlock();
        }


    }
}