package util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lty
 * @Date: 2020/11/24 15:49
 */
public class RedisUtil {

    public static RedisUtil getInstance() {
        return new RedisUtil();
    }

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    static AtomicInteger used = new AtomicInteger();

    private RedisUtil() {
        executorService.scheduleAtFixedRate(()->{
            used.addAndGet(1);
        },0,8888, TimeUnit.MICROSECONDS);
    }


    public int getStack(){
        return used.get();
    }
}
