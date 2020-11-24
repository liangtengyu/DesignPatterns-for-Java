/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_1 {
    //使用懒汉式  非线程安全
    private static Singleton_1 instance =null ;

    private Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        if (instance !=null) return instance;
        return new Singleton_1();
    }
}
