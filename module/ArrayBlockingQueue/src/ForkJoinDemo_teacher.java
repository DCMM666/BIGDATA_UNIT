import java.util.concurrent.*;

public class ForkJoinDemo_teacher {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //求1~100000000000的和所用的时间
        //记录开始时间
        long start = System.currentTimeMillis();
        //循环
        //方式一
        //循环是在主函数中进行的
        //主函数默认就是一个线程类,称之为主线程
        //也就是说ForkJoinDemo就是一个线程类
        //这个线程在执行的时候会随机分配到cpu的某一个核上
        //现在和cpu核是多核,其他的核相对是空闲的
       /*
        long sum = 0;
        for (long i = 0; i < 100000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        */
        //方式二
        ForkJoinPool p = new ForkJoinPool();
        ForkJoinTask<Long> f = p.submit(new Sum(1, 100000000000L));
        System.out.println(f.get());
        p.shutdown();
        //记录结束时间
        long end = System.currentTimeMillis();
        //结束时间-开始时间
        System.out.println(end - start);
    }
}

class Sum extends RecursiveTask<Long> {
    private final long start;
    private final long end;

    public Sum(long start, long end) {
        this.start = start;
        this.end = end;
    }

    //写分叉合并规则的
    @Override
    protected Long compute() {
        if (end - start > 50000) {
            //拆分2半
            long mid = (start + end) / 2;
            Sum left = new Sum(start, mid);
            Sum right = new Sum(mid + 1, end);
            //将拆分2分进行分叉
            left.fork();
            right.fork();
            //合并
            return left.join() + right.join();
        } else {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}

