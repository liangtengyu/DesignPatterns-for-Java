package Channel;

import ModeType.PayType;

/**
 * @Author: lty
 * @Date: 2020/11/20 14:10
 */
public abstract class PayMethod {
    protected PayType payType;

    //构造时 使用protected 修饰, 保证子类能够访问 ,并传入一个需要桥接的接口
    protected PayMethod(PayType payType) {
        this.payType = payType;
    }

    public abstract String doPay(String parkno, String plateNum, String phone);
}
