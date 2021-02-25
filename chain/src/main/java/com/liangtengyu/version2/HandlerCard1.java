package com.liangtengyu.version2;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:51
 */
public class HandlerCard1 extends Handler {
    @Override
    protected boolean doHandle() {
        System.out.println("刷信用卡1 发现没钱,继续找下一张卡");
        return false;
    }
}
