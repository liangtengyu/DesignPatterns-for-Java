/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_2 {
    //使用懒汉式  线程安全 不建议使用
    private static Singleton_2 instance =null ;

    private Singleton_2() {
    }

    public synchronized static Singleton_2 getInstance() {
        if (instance !=null) return instance;
        return new Singleton_2();
    }
}
