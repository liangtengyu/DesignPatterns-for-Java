package com.liangtengyu.version1;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:25
 */
public class HandlerZFB extends Handler {



    @Override
    public void handle() {
        boolean handled = false;
        //region 业务逻辑
        System.out.println("支付宝支付处理逻辑....");
        //endregion
        if (!handled && successor != null) {
            successor.handle();
        }
    }

}
