package eventbus;

import com.google.common.eventbus.Subscribe;
import observer.Message;
import observer.Observer;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:33
 * 实际观察者1 使用同步阻塞式
 */
public class Ob1  {

    @Subscribe
    public void execute(Message message) {
        long l = System.currentTimeMillis();


        System.out.println("第1个观察者 使用同步阻塞式 开始获取消息并处理...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第1个观察者处理完毕:"+message.getMessage());
        System.out.println("操作耗时:"+(System.currentTimeMillis()-l)+"ms");
        System.out.println("-------------------------------------------------------------------------------");
    }


}
