package gw;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class excutor {
        //构造方法:和类同名 没有
        public static void main(String[] args) {
            //构建线程池
            /**
             * int corePoolSize, -核心线程数量
             * int maximumPoolSize, -最大线程数量=核心线程数+临时线程数
             * long keepAliveTime,-临时线程的存活时间
             * TimeUnit unit,-时间单位
             * BlockingQueue<Runnable> workQueue-工作队列
             */
            ExecutorService es=new ThreadPoolExecutor(
                    5,//5个核心线程
                    10,//5个临时线程
                    5, TimeUnit.SECONDS,
                    //new ArrayBlockingQueue<Runnable>(5),//可以临时存储5个任务
                    new ArrayBlockingQueue<Runnable>(7),//可以临时存储5个任务
                    (r, executor) -> {
                        //实际开发中,此处一般用于日志记录
                        System.out.println(new Thread(r).getName()+"被拒绝处理");
                    }
            );
            //ESThread ess=new ESThread();
            //执行任务
            //es.execute(new ESThread());
            //es.submit(new ESThread());
            //5个核心  5个临时   队列容量7
            //for (int i = 0; i < 3; i++) {//3个start  3个stop
            //for (int i = 0; i < 8; i++) {//5个start  后3个start
            //for (int i = 0; i < 15; i++) {//8个start 后7分
            for (int i = 0; i < 13; i++) {//6 6 1
            //for (int i = 0; i < 20; i++) {//10start3个拒绝 7
               es.submit(new ESThread());
            }
            //关闭线程池
            es.shutdown();
        }
    }
    class ESThread1 implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("start");
                Thread.sleep(3000);
                System.out.println("stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


