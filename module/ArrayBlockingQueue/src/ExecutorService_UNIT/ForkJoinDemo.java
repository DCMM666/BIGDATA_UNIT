package ExecutorService_UNIT;

import ExecutorService_UNIT.Sum;

import java.util.concurrent.*;

public class ForkJoinDemo {
    public static void main(String[] args)throws ExecutionException,InterruptedException {
        long start=System.currentTimeMillis();
        /*long sum = 0;
       for (long i=0; i<100000000L; i++) {
            sum +=i;
        }
        System.out.println(sum);*/
        ForkJoinPool p=new ForkJoinPool();
        ForkJoinTask<Long> f = p.submit(new Sum(1, 100000000000L));
        System.out.println(f.get());
        p.shutdown();
        long end=System.currentTimeMillis();
        System.out.println(end - start);

    }
}

class Sum1 extends RecursiveTask<Long> {
    private final long start;
    private final long end;

    public Sum1(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start > 50000) {
            long mid = (start + end) / 2;
            Sum left = new Sum(start, mid);
            Sum right = new Sum(mid + 1, end);
            left.fork();
            right.fork();
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