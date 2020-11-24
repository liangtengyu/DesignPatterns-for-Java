/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_3 {
    //使用饿汉式   线程安全
    private static Singleton_3 instance = new Singleton_3() ;

    private Singleton_3() {
    }

    public  static Singleton_3 getInstance() {

        return instance;
    }
}
