import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class priorityblockingqueue {
    public static void main(String[] args) throws InterruptedException {
       // BlockingQueue<Student1> queue = new PriorityBlockingQueue<>();
        BlockingQueue<Student1> queue=new PriorityBlockingQueue<>(5,(s1,s2)->s1.getScore()-s2.getScore());
        queue.put(new Student1("翠花",18,59));
        queue.put(new Student1("春花",17,90));
        queue.put(new Student1("秋月",13,45));
        queue.put(new Student1("何时了",20,72));
        queue.put(new Student1("小楼",28,61));
        System.out.println(queue);
        for (int i = 0; i < 4; i++) {
            System.out.println(queue.take());
        }
    }
}
class Student1 implements Comparable<Student1>{
        private String name;
        private int age;
        private int score;

        public Student1(String name, int age, int score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }
        //定义排序规则
        //按照年龄降序排列
        @Override
        public int compareTo(Student1 o) {

            return o.age-this.age;
        }

    public int getScore() {
        return score;
    }
}


