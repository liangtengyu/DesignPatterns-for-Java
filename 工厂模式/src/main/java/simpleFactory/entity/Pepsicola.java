package simpleFactory.entity;

import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:26
 */
public class Pepsicola implements Cola {
    public String getCola() {
        System.out.println("生产百事可乐");
        return "百事可乐";
    }
}
