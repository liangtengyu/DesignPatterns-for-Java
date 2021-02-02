package observer;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:33
 * 实际观察者2 异步非阻塞方式
 */
public class ConcreteObserverTwo extends Observer {
    @Override
    @Subscribe

    public void execute(Message message) {
      System.out.println("第2个观察者 异步非阻塞方式 开始获取消息并处理...");
      new Thread( ()->{

          try {
              Thread.sleep(3000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("第2个观察者处理完毕:"+message.getMessage());
       }).start();

    }
}
//使用启动线程的方式,缺点是不易管理,并发量无法控制,频繁地创建和销毁线程比较耗时,创建过多的线程会导致堆栈溢出,可以考虑使用线程池