/**
 * @Author: lty
 * @Date: 2020/11/18 09:24
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        LoggerDecorator loggerDecorator = new LoggerDecorator(
                new ProformanceDecorator(
                        new OrderDecorator()));
        loggerDecorator.execute();
    }
}
