package ExecutorService_UNIT;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

    public class ScheduledExecutorServiceDemo {
        public static void main(String[] args) {
            //构建线程池
            ScheduledExecutorService ses=new ScheduledThreadPoolExecutor(5);
            //推迟指定时间之后启动任务
            //ses.schedule(new ScheduledThread(),5, TimeUnit.SECONDS);
            //1 任务
            //2 是否要推迟执行
            //3 周期
            //4单位
            //从上一次执行开始来计算下一次的启动时间
            //间隔时间=max(执行时间,指定的间隔时间)
            //ses.scheduleAtFixedRate(new ScheduledThread(),0,3,TimeUnit.SECONDS);
            //上一次的结束来计算下一次的启动的时间
            ses.scheduleWithFixedDelay(new ScheduledThread(),0,3, TimeUnit.SECONDS);
        }
    }
    class ScheduledThread implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("hello!");
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

