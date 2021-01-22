package factoryMethod.factorys;

import simpleFactory.entity.Pepsicola;
import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:24
 */
public class PepsiColaFactoryImpl implements ColaFactory {
    public Cola getCola() {
        return new Pepsicola();
    }
}
