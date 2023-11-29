package lock_UNIT;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore s = new Semaphore(6);
        for (int i = 1; i <10;i++){
            new Thread(new eator(s)).start();

        }

    }
}
class eator implements Runnable{
    private  final Semaphore s;
    public  eator (Semaphore s) {
        this.s = s;
    }
    @Override
    public void run() {
        try {
            System.out.println("来了一波客人占用一个桌子");
            Thread.sleep((long) Math.random() * 2000000);
            System.out.println("一波人离开空出一张桌子");
            s.release();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
