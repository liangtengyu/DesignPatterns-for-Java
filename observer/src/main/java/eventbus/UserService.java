package eventbus;

import com.google.common.eventbus.EventBus;
import observer.Message;

/**
 * @Author: lty
 * @Date: 2021/2/1 17:00
 */
public class UserService {
    public Long registerUser(EventBus eventBus){
        System.out.println("注册一个用户 并返回 Message");
        Message message = new Message();
        message.setMessage("用户注册成功");
        message.setId(1000001L);
        eventBus.post(message);
        return 1000001L;
    }
}
