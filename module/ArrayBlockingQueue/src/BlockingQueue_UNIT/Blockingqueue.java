package BlockingQueue_UNIT;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Blockingqueue {
    public  static  void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(3);
        queue.add("lax");
        queue.offer("A");
        queue.put("B");
        queue.remove();
        queue.offer("c", 3, TimeUnit.SECONDS);
        System.out.println(queue);
        students a = new students();
        a.eat();
        Person b = new students();
        b.eat();
        Person c = new Person() {
            @Override
            public void eat() {
                System.out.println("HELLO LAX");
            }
        };
        c.eat();
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

