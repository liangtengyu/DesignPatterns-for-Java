package factoryMethod.factorys;

import simpleFactory.entity.Cocacola;
import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:24
 */
public class CocaColaFactoryImpl implements ColaFactory {
    public Cola getCola() {
        return  new Cocacola();
    }
}
