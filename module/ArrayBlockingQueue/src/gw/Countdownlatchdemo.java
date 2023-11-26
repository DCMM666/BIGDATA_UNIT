package gw;
import java.util.concurrent.CountDownLatch;
public class Countdownlatchdemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        new Thread(new teacher(latch),"a").start();
        new Thread(new teacher(latch),"b").start();
        new Thread(new student(latch),"A").start();
        new Thread(new student(latch),"B").start();
        latch.await();
        System.out.println("开始考试");
    }
}
class teacher implements Runnable{
    private final CountDownLatch latch;
    public teacher(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((long) Math.random() *10000);
            System.out.println(Thread.currentThread().getName() + "到达考场");
            latch.countDown();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
class student implements Runnable{
    private final CountDownLatch latch;

    public student(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((long) Math.random() *100000);
            System.out.println(Thread.currentThread().getName() + "到达考场");
            latch.countDown();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

