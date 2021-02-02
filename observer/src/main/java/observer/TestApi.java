package observer;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:37
 */
public class TestApi {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("我一是条需要处理的信息");
        message.setId(1L);

        ConcreteObserver concreteObserver = new ConcreteObserver();
        ConcreteObserverTwo concreteObserverTwo = new ConcreteObserverTwo();
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(concreteObserver);
        concreteSubject.registerObserver(concreteObserverTwo);
        concreteSubject.notifyMessage(message);
    }
}
