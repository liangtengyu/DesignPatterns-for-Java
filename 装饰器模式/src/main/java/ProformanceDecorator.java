/**
 * @Author: lty
 * @Date: 2020/11/18 09:20
 */
public class ProformanceDecorator implements Command {

    Command command;

    public ProformanceDecorator(Command command) {
        this.command = command;
    }

    public void execute() throws InterruptedException {
        System.out.println("性能装饰器启动..");
        long l = System.currentTimeMillis();
        this.command.execute();
        Thread.sleep(100);
        System.out.println("操作耗时:"+(System.currentTimeMillis()-l));
    }
}
