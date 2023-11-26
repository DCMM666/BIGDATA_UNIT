package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EXECUTOR {
    public static void main(String[] args) {
        ExecutorService ES =new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5),
                (a,executor) ->{
                    System.out.println(new Thread(a).getName() + "未被执行");
                });
        A  B =new A();
        ES.execute(B);
        ES.execute(new A());
        ES.shutdown();

    }


}
class  A implements  Runnable{

    @Override
    public void run() {
        try {
            System.out.println("start");
            Thread.sleep(3000);
            System.out.println("stop");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
