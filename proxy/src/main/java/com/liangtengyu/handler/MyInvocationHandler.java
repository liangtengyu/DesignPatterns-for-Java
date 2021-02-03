package com.liangtengyu.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: lty
 * @Date: 2021/2/3 14:56
 */
public class MyInvocationHandler<T> implements InvocationHandler {
    private T obj;

    public MyInvocationHandler(T obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在代理之前 操作其它...");
        Object invoke = method.invoke(obj, args);
        System.out.println(invoke);
        System.out.println("在代理之后 操作其它...");

        return invoke;

    }
}
