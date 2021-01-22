/**
 * @Author: lty
 * @Date: 2021/1/22 09:36
 */
public class DebugHandler implements Handler {
    Handler handler;
    public DebugHandler(Handler handler) {
        this.handler = handler;
    }

    public void execute() {
        System.out.println("Debug handler execute before");
        this.handler.execute();
        System.out.println("Debug handler execute after");
    }
}
