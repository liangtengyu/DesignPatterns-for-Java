package com.lty.design.factory.Impl;

import com.lty.design.factory.CacheSelector;
import com.lty.design.util.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lty
 * @Date: 2020/11/12 13:55
 */
public class IIRCacheSelector implements CacheSelector {

    private IIR iir = new IIR();

    public String get(String key) {
        return iir.get(key);
    }

    public void set(String key, String value) {
        iir.set(key,value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    public void del(String key) {
        iir.del(key);
    }
}
