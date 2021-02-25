package com.liangtengyu.version1;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:28
 */
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;

    public void handler() {
        if (null != head) {
            head.handle();
        }
    }

    public void setHandler(Handler handler) {
        //如果链表头为空 将链表头设置成当前handler 链表尾部也是这个handler 返回
        if (head == null) {
            head= handler;
            tail = handler;
            return;
        }
        //如果 头部不为空 表示有别的handler, 这时只需要在尾部的处理器的successor中加入handler 就成功加入了chain
        tail.successor = handler;
        //, 然后再更新尾部标志为新加入的handler
        tail = handler;
    }
}
