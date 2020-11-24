package com.lty.design.factory;

import java.lang.reflect.Proxy;

/**
 * @Author: lty
 * @Date: 2020/11/13 09:42
 */
public class GetProxy {
    public static CacheSelector GetSelector(CacheSelector cacheSelector) {
        CacheSelector o = (CacheSelector)Proxy.newProxyInstance(cacheSelector.getClass().getClassLoader()
                , cacheSelector.getClass().getInterfaces(), new CacheSelectorHandler<CacheSelector>(cacheSelector));
        return o;
    }
}
