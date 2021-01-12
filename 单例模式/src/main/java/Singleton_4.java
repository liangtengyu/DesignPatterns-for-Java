import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_4 {
    //使用内部类方式构造单例, 线程安全并且懒加载
    private AtomicInteger id = new AtomicInteger(0);


    private Singleton_4() {
    }

     public static  Singleton_4 getInstance(){
        return SingletonCreator.singleton_4;
    }

    private static class SingletonCreator{
        static  Singleton_4 singleton_4 = new Singleton_4();

    }
    public Integer getIncrementId(){
        return this.id.getAndIncrement();
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //获取实例
            Singleton_4 instance = Singleton_4.getInstance();
            //输出地址
            System.out.println("实例的地址:" + instance);
            //获取id
            System.out.println(instance.getIncrementId());
            System.out.println("-------------------------------------------------");
        }
    }
}
