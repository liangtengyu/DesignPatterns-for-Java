package simpleFactory.entity;

import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:26
 */
public class Fakecola implements Cola {
    public String getCola() {
        System.out.println("生产假冒伪劣可乐");
        return "假冒伪劣可乐";
    }
}
