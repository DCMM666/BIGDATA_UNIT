package gw;

public class lambda {
    public static void main(String[] args){

        MAX abc = new MAX(){

            @Override
            public double MAX(double x, double y) {
                return 0;
            }
        };

        MAX DCMM =(double x, double y)->{

            return x>y?x:y;

        };
        MAX ABC = (double x, double y)->Math.max(x,y);
        System.out.println(DCMM.MAX(5.1,6.3));
        MAX m3=(double a,double b )-> Math.max(a,b);
        System.out.println(m3.MAX(2.11,3.22));

        MAX m4=( a, b )-> Math.max(a,b);
        System.out.println(m4.MAX(2.11,3.22));

        MAX m5=Math::max;
        System.out.println(m5.MAX(1.21,3.08));


    }
}
interface  MAX{
    double MAX(double x, double y);

}
class M1 implements MAX{

    @Override
    public double MAX(double x, double y) {
        return 0;
    }
}
