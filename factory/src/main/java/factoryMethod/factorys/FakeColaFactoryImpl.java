package factoryMethod.factorys;

import simpleFactory.entity.Fakecola;
import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:24
 */
public class FakeColaFactoryImpl implements ColaFactory {
    public Cola getCola() {
        return new Fakecola();
    }
}
