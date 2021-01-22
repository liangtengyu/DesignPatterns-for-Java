package abstractFactory.producer;

import abstractFactory.ColaAbstractFactoryImpl;
import abstractFactory.color.ColorFactory;
import com.sun.xml.internal.rngom.digested.DChoicePattern;
import factoryMethod.factorys.ColaFactory;
import simpleFactory.interfaces.Cola;

/**
 * @Author: lty
 * @Date: 2021/1/12 15:04
 */
public class FactoryProducer {
    public static String getColaAndColor(String cola,String color){
        ColaAbstractFactoryImpl colaAbstractFactory = new ColaAbstractFactoryImpl();

        ColaFactory cocacola = colaAbstractFactory.getCola(cola);
        ColorFactory red = colaAbstractFactory.getColor(color);

        Cola col = cocacola.getCola();
        String colo = red.getColor();
        return col.getCola()+"-"+colo;
    }
}
