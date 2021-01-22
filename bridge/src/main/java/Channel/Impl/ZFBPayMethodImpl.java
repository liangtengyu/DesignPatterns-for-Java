package Channel.Impl;

import Channel.PayMethod;
import ModeType.PayType;

/**
 * @Author: lty
 * @Date: 2020/11/20 14:14
 */
public class ZFBPayMethodImpl extends PayMethod {
    public ZFBPayMethodImpl(PayType payType) {
        super(payType);
    }

    @Override
    public String doPay(String parkno, String plateNum, String phone) {
        System.out.println("zfb-->>");
        String s = payType.toPay();
        System.out.println(s);
        return null;
    }
}
