package abstractFactory;

import abstractFactory.color.ColorFactory;
import abstractFactory.color.Impl.BlueColorFactoryImpl;
import abstractFactory.color.Impl.RedColorFactoryImpl;
import abstractFactory.color.Impl.YellowColorFactoryImpl;
import factoryMethod.factorys.CocaColaFactoryImpl;
import factoryMethod.factorys.ColaFactory;
import factoryMethod.factorys.FakeColaFactoryImpl;
import factoryMethod.factorys.PepsiColaFactoryImpl;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:45
 */
public class ColaAbstractFactoryImpl extends ColaAbstractFactory {


   public ColaFactory getCola(String cola) {
        if ("cocacola".equals(cola)) {
            return new CocaColaFactoryImpl();
        } else if ("fake".equals(cola)) {
            return new FakeColaFactoryImpl();
        } else if ("pepsi".equals(cola)) {
            return new PepsiColaFactoryImpl();
        } else
            return null;
    }

    public ColorFactory getColor(String color) {
        if ("yellow".equals(color)) {
            return new YellowColorFactoryImpl();
        } else if ("blue".equals(color)) {
            return new BlueColorFactoryImpl();
        } else if ("red".equals(color)) {
            return new RedColorFactoryImpl();
        } else
            return null;
    }
}
