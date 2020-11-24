import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_6 {
    //使用atomicrefence  使用CAS方式  支持懒加载
    private static AtomicReference<Singleton_6> INSTANCE = new AtomicReference<Singleton_6>();

    private Singleton_6() {
    }

    public static Singleton_6 getInstance(){
        for (; ; ) {
            Singleton_6 singleton_6 = INSTANCE.get();
            if (null != singleton_6)return singleton_6;
            INSTANCE.compareAndSet(null, new Singleton_6());
            return INSTANCE.get();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Singleton_6.getInstance());
        System.out.println(Singleton_6.getInstance());



    }

}
