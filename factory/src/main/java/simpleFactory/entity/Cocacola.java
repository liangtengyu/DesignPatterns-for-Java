package simpleFactory.entity;

import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:26
 */
public class Cocacola implements Cola {
    public String getCola() {
        System.out.println("生产可口可乐");
        return "可口可乐";
    }
}
