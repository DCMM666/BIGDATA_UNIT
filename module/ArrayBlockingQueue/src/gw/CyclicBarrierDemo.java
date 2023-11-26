package gw;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier a = new CyclicBarrier(4);
        new Thread(new cd(a),"one").start();
        new Thread(new cd(a),"two").start();
        new Thread(new cd(a),"three").start();
        new Thread(new cd(a),"four").start();
    }
}
class cd implements Runnable {
    private final CyclicBarrier a;
    public cd(CyclicBarrier a) {
        this.a = a;
    }
    @Override
    public void run() {
        try {
            String name =Thread.currentThread().getName();
            Thread.sleep((long) Math.random()*10000);
            System.out.println(name+" 到达起跑线");
            a.await();
            System.out.println(name+"跑出去");


        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}