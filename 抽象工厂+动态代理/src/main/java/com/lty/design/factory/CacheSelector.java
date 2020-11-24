package com.lty.design.factory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lty
 * @Date: 2020/11/12 13:53
 */
public interface CacheSelector {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
