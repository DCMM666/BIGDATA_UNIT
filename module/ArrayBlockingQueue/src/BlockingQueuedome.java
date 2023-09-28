import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueuedome {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue=new LinkedBlockingQueue<>();
        queue.add("abx");
        //System.out.println(queue.remove());
        //System.out.println(queue.poll());
        //永久阻塞
        //System.out.println(queue.take());
        //定时阻塞
        System.out.println(queue.poll(30, TimeUnit.SECONDS));
        //queue.remove();
        System.out.println(queue);
    }
}
