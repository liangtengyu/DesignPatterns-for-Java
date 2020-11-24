package com.lty.design.factory;

import com.lty.design.factory.Impl.IIRCacheSelector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: lty
 * @Date: 2020/11/12 14:30
 */
public class Main {
//    public static void main(String[] args) {
//        CacheSelector iirCacheSelector = new IIRCacheSelector();
//        CacheSelectorHandler handler = new CacheSelectorHandler(iirCacheSelector);
//        CacheSelector o = (CacheSelector)Proxy.newProxyInstance(handler.getClass().getClassLoader(), iirCacheSelector.getClass().getInterfaces(),
//                handler);
//        o.set("key", "value1");
//        String key = o.get("key");
//        System.out.println(key);
//
//    }


    public static void main(String[] args) {
        IIRCacheSelector iirCacheSelector = new IIRCacheSelector();
        CacheSelector cacheSelector = GetProxy.GetSelector(iirCacheSelector);
        cacheSelector.set("key", "value123");
        String key = cacheSelector.get("key");
        System.out.println(key);
    }

}
