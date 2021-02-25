package com.liangtengyu.version2;

/**
 * @Author: lty
 * @Date: 2021/2/25 09:56
 */
public class Test {
    public static void main(String[] args) {
        HandlerChainForCard handlerChainForCard = new HandlerChainForCard();
        handlerChainForCard.setHandler(new HandlerCard1());
        handlerChainForCard.setHandler(new HandlerCard2());
        handlerChainForCard.setHandler(new HandlerCard1());
        handlerChainForCard.setHandler(new HandlerCard2());
        handlerChainForCard.handle();
    }
}
