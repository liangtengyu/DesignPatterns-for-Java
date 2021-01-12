package factoryMethod.test;

import factoryMethod.factorys.ColaFactory;
import factoryMethod.factorys.PepsiColaFactoryImpl;
import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:19
 */
public class Main {
    public static void main(String[] args) {
        //工厂方法需要一个可乐时,直接去对应的工厂拿,而是不像简单工厂那样 都是从一个工厂中根据判断来拿
        //每一种可乐都对应一个工厂
        ColaFactory pepsiColaFactory = new PepsiColaFactoryImpl();
        Cola cola = pepsiColaFactory.getCola();
        cola.getCola();
    }
}
