/**
 * @Author: lty
 * @Date: 2020/11/13 16:13
 */
public class Singleton_5 {
    //使用双重锁校验 线程安全
    private static Singleton_5 instance =null ;
    //满足懒加载
    private Singleton_5() {
    }

    public  static Singleton_5 getInstance() {
        if (instance !=null) return instance;
        synchronized (Singleton_5.class) {
            if (instance == null) {
                return new Singleton_5();
            }
        }
        return new Singleton_5();
    }
}
