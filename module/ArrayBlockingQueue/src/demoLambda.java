public class demoLambda {
    public static void main(String[] args) {
        Dog d=new Dog();
        //cat1 a=new cat1();
        //d.eat(a);
        /*d.eat(new Cat() {
            @Override
            public void eat(int a, double b) {

            }
        });*/
        d.eat(
                ( a,  b) ->{

                }
        );
    }
}
class  Dog{
    public void eat(Cat cat){
        System.out.println("我吃了"+cat);
    }
}
interface Cat{
    public void eat(int a,double b);
}
class cat1 implements Cat{

    @Override
    public void eat(int a, double b) {


    }
}