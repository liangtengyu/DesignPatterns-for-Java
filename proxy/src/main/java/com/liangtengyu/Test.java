package com.liangtengyu;


import com.liangtengyu.handler.MyInvocationHandler;
import com.liangtengyu.proxy.MyProxy;
import com.liangtengyu.service.Handler;
import com.liangtengyu.service.MyHandler;

/**
 * @Author: lty
 * @Date: 2021/2/3 14:44
 */
public class Test {
    public static void main(String[] args) {

        //使用代理
        MyProxy<Handler> handlerMyProxy = new MyProxy<>();
        Handler proxy = handlerMyProxy.getProxy(new MyHandler());
        proxy.execute();

    }
}
