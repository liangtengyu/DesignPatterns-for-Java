package com.liangtengyu.impl;

import com.liangtengyu.interfaces.Iterator;

import java.util.ArrayList;

/**
 * @Author: lty
 * @Date: 2021/2/27 09:28
 */
public class ArrayIterator<E> implements Iterator<E> {
   int curse;
   ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.curse = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasnext() {
        return curse !=arrayList.size();
    }

    @Override
    public E getElement() {
        return arrayList.get(this.curse);
    }

    @Override
    public void next() {
        curse++;
    }
}
