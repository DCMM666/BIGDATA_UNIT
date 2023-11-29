package ExecutorService_UNIT;

import java.util.concurrent.*;

public class ExecutorServicedemo {
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
                    new ArrayBlockingQueue<Runnable>(5),//可以临时存储5个任务
                    (r, executor) -> {
                        //实际开发中,此处一般用于日志记录
                        System.out.println(new Thread(r).getName()+"被拒绝处理");
                    }
            );
            //ESThread ess=new ESThread();
            //执行任务
            es.execute(new ESThread());
            //关闭线程池
            es.shutdown();
        }
    }
    class ESThread implements Runnable{
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
