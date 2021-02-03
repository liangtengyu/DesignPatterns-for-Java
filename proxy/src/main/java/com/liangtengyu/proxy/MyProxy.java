package com.liangtengyu.proxy;

import com.liangtengyu.handler.MyInvocationHandler;
import com.liangtengyu.service.Handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: lty
 * @Date: 2021/2/3 14:58
 */
public class MyProxy<T> {
    public T getProxy(T obj) {
        MyInvocationHandler<T> tMyInvocationHandler = new MyInvocationHandler<>(obj);
        return (T) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), obj.getClass().getInterfaces(), tMyInvocationHandler);
    }
}
