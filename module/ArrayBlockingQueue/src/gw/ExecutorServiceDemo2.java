package gw;

import java.util.concurrent.*;
/**
 * SynchronousQueue - 同步队列,
 * 在使用的时候不需要指定容量,容量为1且固定为1.
 */
public class ExecutorServiceDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         /* 特点:
         * 1 没有核心线程,全部都是临时线程
         * 2 临时线程的数量为Integer.MAX_VALUE
         *    因为现阶段的单服务器不可能处理21亿个线程
         *    此时我们认为这个线程池可以处理无限多个请求
         * 3  临时线程用完之后的存活时间1min
         * 4 工作队列是同步队列
         */
        //大池子小队列
        //适合于并发高短任务的场景,例如秒杀,即时通信
        //ExecutorService es= Executors.newCachedThreadPool();
         /* 特点:
         * 1 没有临时线程,全部都是核心线程
         * 2 工作队列是阻塞式的链式队列
         *   此时可以认为这个队列存储无限多的请求
         */
        //小池子大队列
        //适合并发低长任务场景,例如文件下载
        ExecutorService es=Executors.newFixedThreadPool(5);
        Future<Integer> f = es.submit(new CallableThread1());
        System.out.println(f.get());
        es.shutdown();
    }
}
class CallableThread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("HELLO!");
        Thread.sleep(3000);
        return 404;
    }
}