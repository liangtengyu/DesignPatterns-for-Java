package com.liangtengyu.version2;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:51
 */
public class HandlerCard2 extends Handler {
    @Override
    protected boolean doHandle() {
        System.out.println("信用卡2有钱 处理完毕!");
        return true;
    }
}
