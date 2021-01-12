package entity;

import interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:26
 */
public class Cocacola implements Cola {
    public String drink() {
        System.out.println("喝可口可乐");
        return "喝可口可乐";
    }
}
