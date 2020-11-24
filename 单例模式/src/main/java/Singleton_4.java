/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_4 {
    //使用内部类方式构造单例, 线程安全并且懒加载
    private Singleton_4() {
    }

     private static  Singleton_4 getInstance(){
        return SingletonCreator.singleton_4;
    }

    private static class SingletonCreator{
        static  Singleton_4 singleton_4 = new Singleton_4();

    }


    public static void main(String[] args) {
        System.out.println(Singleton_4.getInstance());
        System.out.println(Singleton_4.getInstance());
    }
}
