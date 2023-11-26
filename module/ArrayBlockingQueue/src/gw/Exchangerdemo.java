package gw;

import java.util.concurrent.Exchanger;

public class Exchangerdemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger();
        new Thread(new seller(exchanger)).start();
        new Thread(new courst(exchanger)).start();


    }
}
class seller implements Runnable{
    private  final  Exchanger<String>  ex;

     public seller(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
         try {
             String INFO = "钱";
             String seller =ex.exchange(INFO);
             System.out.println("卖家收到了"+INFO);
         } catch (Exception e) {
             throw new RuntimeException(e);
         }

    }
}
class courst implements Runnable{
    private  final  Exchanger<String>  ex;

    public courst(Exchanger<String> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        try {
            String INFO = "商品";
            String seller =ex.exchange(INFO);
            System.out.println("买家收到了"+INFO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}