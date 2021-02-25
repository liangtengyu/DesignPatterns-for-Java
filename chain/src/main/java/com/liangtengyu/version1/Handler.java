package com.liangtengyu.version1;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:23
 */
public abstract class Handler {
    protected Handler successor = null;

    public void setHandler(Handler successor) {
        this.successor = successor;
    }

    public abstract void handle();
}
