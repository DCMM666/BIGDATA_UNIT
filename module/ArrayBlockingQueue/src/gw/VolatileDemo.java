package gw;

public class VolatileDemo{
    private int i;

    public static void main(String[] args) throws InterruptedException {
        Data t = new Data();
        t.i = 7;
        new Thread(() -> {
            System.out.println("A-Running");
            while (t.i == 7) ;
            System.out.println("A-STOP");
        }).start();
        Thread.sleep(3000);
        new Thread(() -> {
            System.out.println("B-Running");
            t.i = 5;
            System.out.println("B-STOP");
        }).start();
    }
}
class Data{
    volatile int i;
}