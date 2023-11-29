package ExecutorService_UNIT;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread1 test=new Thread1();
        test.start();
        Thread2 T2=new Thread2();
        T2.run();
        Thread A =new Thread(T2);
        A.start();


        ExecutorService ES =new ThreadPoolExecutor(5,10,
                5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>()
                );
        FutureTask  t = new FutureTask(new CallableThread());
        ES.submit(new CallableThread());
        ES.shutdown();


        FutureTask<Integer> S = new FutureTask<Integer>(new CallableThread());
        new Thread(S).start(); // 启动线程执行任务
        try {
            System.out.println(t.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }
}
class Thread1 extends Thread{//实现继承的方法,启动线程

    @Override
    public void run() {
        }

    }


class Thread2 implements Runnable{//实现接口的方法，启动线程

    @Override
    public void run() {
        System.out.println("Thread2");
    }
}

class CallableThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("-----------");
        Thread.sleep(100);
        return 404;
    }
}

