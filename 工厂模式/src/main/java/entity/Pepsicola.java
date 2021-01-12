package entity;

import interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:26
 */
public class Pepsicola implements Cola {
    public String drink() {
        System.out.println("喝百事可乐");
        return "喝百事可乐";
    }
}
