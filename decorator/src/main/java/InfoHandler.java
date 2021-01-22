/**
 * @Author: lty
 * @Date: 2021/1/22 09:35
 */
public class InfoHandler implements Handler {
    Handler handler;
    public InfoHandler(Handler handler) {
        this.handler = handler;
    }

    public void execute() {
        System.out.println("info handler execute before");
        this.handler.execute();
        System.out.println("info handler execute after");
    }
}
