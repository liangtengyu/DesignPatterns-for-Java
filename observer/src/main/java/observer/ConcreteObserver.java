package observer;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:33
 * 实际观察者1 使用同步阻塞式
 */
public class ConcreteObserver extends Observer {
    @Override
    @Subscribe
    public void execute(Message message) {
        System.out.println("第1个观察者 使用同步阻塞式 开始获取消息并处理...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第1个观察者处理完毕:"+message.getMessage());

    }
}
