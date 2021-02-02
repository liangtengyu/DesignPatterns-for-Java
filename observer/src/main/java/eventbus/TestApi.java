package eventbus;



import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/2/1 17:08
 */
public class TestApi {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        Ob1 ob1 = new Ob1();
        Ob2 ob2 = new Ob2();

        List<Object> obs = new ArrayList<>();
        obs.add(ob1);
        obs.add(ob2);

        UserController userController = new UserController();
        userController.setObservers(obs);
        userController.register();
        System.out.println("主线程 操作耗时:"+(System.currentTimeMillis()-l)+"ms");
    }
}
