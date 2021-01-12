package entity;

import interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:26
 */
public class Fakecola implements Cola {
    public String drink() {
        System.out.println("喝假冒伪劣可乐");
        return "喝假冒伪劣可乐";
    }
}
