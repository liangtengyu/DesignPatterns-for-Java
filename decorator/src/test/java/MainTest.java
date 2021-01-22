import org.junit.Test;

/**
 * @Author: lty
 * @Date: 2021/1/22 09:37
 */
public class MainTest {
    @Test
    public void test(){
        DebugHandler debugHandler = new DebugHandler(new InfoHandler(new MyMessageHandler()));
        debugHandler.execute();
    }
}
