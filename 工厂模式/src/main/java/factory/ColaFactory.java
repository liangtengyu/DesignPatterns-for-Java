package factory;

import entity.Cocacola;
import entity.Fakecola;
import entity.Pepsicola;
import interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:28
 */
public class ColaFactory {

    public static Cola getInstance(Integer  colaType) {
        if (1 == colaType) {
            return new Cocacola();
        } else if (2 == colaType) {
            return new Pepsicola();
        } else {
            return new Fakecola();
        }
    }

}
