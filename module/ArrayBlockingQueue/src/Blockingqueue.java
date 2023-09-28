import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Blockingqueue {
    public  static  void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(3);
        queue.add("foo");
        queue.offer("bar");
        queue.put("BAR");
        queue.remove();
        //System.out.println(queue.offer("abc"));
        //queue.put("abc");//永久阻塞
        //定时阻塞
        queue.offer("c", 3, TimeUnit.SECONDS);
        System.out.println(queue);//顺序队列按顺序排列数组
        student a = new student();
        a.eat();
        Person b = new student();
        b.eat();
        Person c = new Person() {
            @Override

            public void eat() {
                //匿名内部类
                System.out.println("OI");
            }
        };
        c.eat();
    }
}
interface Person{
    public  void eat();
}
class student implements Person {

    @Override
    public void eat() {
        //外部类
        System.out.println("Hello");
    }
}

