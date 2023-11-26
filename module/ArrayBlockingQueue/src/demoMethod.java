public class demoMethod {
    //构造方法:和类同名  没有返回值也没有void
    //在new对象的时候执行
    public demoMethod(int a){
        System.out.println("我是构造");
    }


    //方法
    //访问修饰词  返回值类型  方法名(参数列表){方法体}
    //返回值:方法执行完后有结果
    //void 表示这个方法没有返回值
    public void sleep(){}
    public String say(){
        System.out.println("哈哈哈");
        return "1";
    }
    public String say1(int a){
        System.out.println("哈哈哈");
        return "1";
    }
    //返回值 和参数 分为4中
    //无参无返
    public void a(){}
    //无参有返
    public boolean b(){
        return true;
    }
    //有参有返
    public int c(int a,int b){
        return a+b;
    }
    //有参无返
    public void d(String name){
        System.out.println(name);
    }

    public static void main(String[] args) {
        //方法的调用
        //对象名.方法名();
        demoMethod d=new demoMethod(1);
        String a=d.say();
        d.say1(1);
    }
}
