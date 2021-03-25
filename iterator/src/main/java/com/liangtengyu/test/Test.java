package com.liangtengyu.test;

import com.liangtengyu.impl.ArrayIterator;
import com.liangtengyu.interfaces.Iterator;

import java.util.ArrayList;

/**
 * @Author: lty
 * @Date: 2021/2/27 09:31
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("lty");
        list.add("lty1");
        list.add("lty2");

        Iterator<String> stringIterator = new ArrayIterator<>(list);
        while (stringIterator.hasnext()) {
            System.out.println(stringIterator.getElement());
            stringIterator.next();
        }
    }
}
