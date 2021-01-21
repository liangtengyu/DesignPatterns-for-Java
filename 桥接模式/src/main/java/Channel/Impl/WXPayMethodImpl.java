package Channel.Impl;

import Channel.PayMethod;
import ModeType.PayType;

/**
 * @Author: lty
 * @Date: 2020/11/20 14:14
 */
public class WXPayMethodImpl extends PayMethod {
    public WXPayMethodImpl(PayType payType) {
        super(payType);
    }

    @Override
    public String doPay(String parkno, String plateNum, String phone) {
        System.out.println("wx-->>");
        String s = payType.toPay();
        System.out.println(s);
        return "支付调用完毕";
    }
}
