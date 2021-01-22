package abstractFactory.test;

import abstractFactory.ColaAbstractFactory;
import abstractFactory.ColaAbstractFactoryImpl;
import abstractFactory.color.ColorFactory;
import abstractFactory.producer.FactoryProducer;
import factoryMethod.factorys.CocaColaFactoryImpl;
import factoryMethod.factorys.ColaFactory;
import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2021/1/12 15:02
 */
public class Main {
    public static void main(String[] args) {
        String colaAndColor = FactoryProducer.getColaAndColor("fake", "yellow");
        System.out.println(colaAndColor);

    }
}
