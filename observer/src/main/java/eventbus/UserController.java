package eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import observer.Observer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: lty
 * @Date: 2021/2/1 17:00
 */
public class UserController {
    private UserService userService;

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE=10;

    public UserController(){
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));//构造方法中创建线程池
    }

    public void setObservers(List<Object> observers) {
        for (Object Object : observers) {
            eventBus.register(Object);
        }
    }

    public void register() {
        userService = new UserService();
        userService.registerUser(eventBus);
    }
}
