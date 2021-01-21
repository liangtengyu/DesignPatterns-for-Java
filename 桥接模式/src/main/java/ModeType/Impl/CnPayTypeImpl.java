package ModeType.Impl;

import ModeType.PayType;

/**
 * @Author: lty
 * @Date: 2020/11/20 14:11
 */
public class CnPayTypeImpl implements PayType {
    public String toPay() {
        System.out.println("使用场内支付..");
        return "使用场内支付成功";
    }
}
