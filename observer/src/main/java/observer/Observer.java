package observer;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:29
 */
public abstract class Observer {
    abstract void execute(Message message);


    public void executeAndGetTime(Message message) {
        long l = System.currentTimeMillis();
        execute(message);
        System.out.println("操作耗时:"+(System.currentTimeMillis()-l)+"ms");
        System.out.println("-------------------------------------------------------------------------------");
    }




}
