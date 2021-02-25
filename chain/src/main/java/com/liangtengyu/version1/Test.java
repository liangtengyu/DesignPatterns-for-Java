package com.liangtengyu.version1;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:34
 */
public class Test {
    public static void main(String[] args) {
        HandlerWX handlerWX = new HandlerWX();
        HandlerZFB handlerZFB = new HandlerZFB();
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.setHandler(handlerWX);
        handlerChain.setHandler(handlerZFB);
        handlerChain.handler();
    }
}
