package com.lty.design.factory.Impl;

import com.lty.design.factory.CacheSelector;
import com.lty.design.util.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lty
 * @Date: 2020/11/12 13:56
 */
public class EGMCacheSelector implements CacheSelector {

    private EGM egm = new EGM();

    public String get(String key) {
        return egm.gain(key);
    }

    public void set(String key, String value) {
        egm.set(key,value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        egm.delete(key);
    }
}
