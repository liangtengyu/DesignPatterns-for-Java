import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: lty
 * @Date: 2020/11/18 09:16
 */
public class LoggerDecorator implements Command {
    Command cmd;

    //构造方法中需要传入下一个需要装饰的类
    public LoggerDecorator(Command cmd) {
        this.cmd = cmd;
    }


    public void execute() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("开始纪录日志");
        logger.debug(".....");
        this.cmd.execute();         //运行自己的代码 中间插入构造器中传入的装饰器运行.  传入的装饰器 有可能还有装饰..
        logger.debug(".....");
    }
}
