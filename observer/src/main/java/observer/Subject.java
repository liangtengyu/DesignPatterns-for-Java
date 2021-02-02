package observer;

/**
 * @Author: lty
 * @Date: 2021/2/1 09:31
 */
public interface Subject {
    void registerObserver(Observer ob);

    void removeObserver(Observer observer);

    void notifyMessage(Message message);
}
