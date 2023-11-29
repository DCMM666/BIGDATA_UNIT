package Atomic_UNIT;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomicdemo {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new add2()).start();
        new Thread(new add2()).start();
        Thread.sleep(5000);
        System.out.println(ai);
    }

}
class add2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            //Atomicdemo.ai.getAndAdd(1);
            //Atomicdemo.ai.addAndGet(1);
            //Atomicdemo.ai.getAndIncrement();
            Atomicdemo.ai.incrementAndGet();
        }

    }
}