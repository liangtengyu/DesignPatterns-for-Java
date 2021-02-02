package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:34
 * 实际被观察者
 */
public class ConcreteSubject implements Subject {
    private final List<Observer> obs = new ArrayList<>();

    @Override
    public void registerObserver(Observer ob) {
        this.obs.add(ob);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.obs.remove(observer);
    }

    @Override
    public void notifyMessage(Message message) {
        for (Observer ob : obs) {
            ob.executeAndGetTime(message);
        }
    }
}
