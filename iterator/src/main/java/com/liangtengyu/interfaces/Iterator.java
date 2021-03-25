package com.liangtengyu.interfaces;

/**
 * @Author: lty
 * @Date: 2021/2/27 09:26
 */
public interface Iterator<E> {
     boolean hasnext();
     E getElement();
     void next();

}
