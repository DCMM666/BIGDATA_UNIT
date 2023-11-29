package ExecutorService_UNIT;

import java.util.concurrent.*;

public class CallableDemo {public static void main(String[] args) throws ExecutionException, InterruptedException {
    //方式一
    //将Callable类型的对象转化为Runnable类型
    //Callable ->FutureTask-> RunnableFuture->Runnable
       /* FutureTask<Integer> t=new FutureTask<>(new ExecutorService_UNIT.CallableThread());
        new Thread(t).start();
        System.out.println(t.get());
        */

    //方式二:通过线程池来启动Callable
    ExecutorService es=new ThreadPoolExecutor(5,10,5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>());
    Future<Integer> f = es.submit(new CallableThreadS());
    //执行完任务的结果
    System.out.println(f.get());
    es.shutdown();
}
}
//泛型表示的是线程执行完之后返回的结果的类型
class CallableThreadS implements Callable<Integer> {
    //call方法里面是写需要线程执行的业务
    @Override
    public Integer call() throws Exception {
        System.out.println("哈哈哈");
        return 404;
    }
}









