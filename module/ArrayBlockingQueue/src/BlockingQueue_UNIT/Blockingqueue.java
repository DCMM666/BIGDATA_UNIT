package BlockingQueue_UNIT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Blockingqueue {
    public  static  void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(3);
        queue.add("lax");
        queue.offer("A");
        queue.put("B");
        queue.remove();
        queue.offer("c", 3, TimeUnit.SECONDS);
        //add、offer、put这3个方法都是往队列尾部添加元素，区别如下：
        //add：不会阻塞，添加成功时返回true，不响应中断，当队列已满导致添加失败时抛出IllegalStateException。
        // offer：不会阻塞，添加成功时返回true，因队列已满导致添加失败时返回false，不响应中断。
        System.out.println(queue);
        students a = new students();
        a.eat();
        Person b = new students();//父接口创建子类
        b.eat();
        //匿名内部类
        Person c = new Person() {
            @Override
            public void eat() {
                System.out.println("HELLO LAX");
            }
        };
        c.eat();
        BlockingQueue<String> LINK = new LinkedBlockingQueue<>(3);
        LINK.add("a");
        LINK.add("b");
        LINK.add("c");
        System.out.println(LINK.poll(30,TimeUnit.SECONDS));
        //poll：会响应中断，会阻塞，阻塞时间参照方法里参数timeout.timeUnit，当阻塞时间到了还没取得元素会返回null
        System.out.println(LINK.take());
        //take 方法的功能是获取并移除队列的头结点，通常在队列里有数据的时候是可以正常移除的。 可是一旦执行 take 方法的时候，队列里无数据，则阻塞，直到队列里有数据。

    }
}
interface Person{
    public  void eat();
}
class students implements Person {

    @Override
    public void eat() {

        System.out.println("Hello");
    }
}

