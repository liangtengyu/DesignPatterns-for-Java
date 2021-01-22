import Channel.Impl.WXPayMethodImpl;
import Channel.PayMethod;
import ModeType.Impl.GtPayTypeImpl;
import org.junit.Test;

/**
 * @Author: lty
 * @Date: 2020/11/20 10:03
 */
public class TestMain {
    @Test
    public void Test(){
        PayMethod payMethod = new WXPayMethodImpl(new GtPayTypeImpl());
        String 浙BWWWWW = payMethod.doPay("1268", "浙BWWWWW", "10086");
        System.out.println(浙BWWWWW);
    }
}
