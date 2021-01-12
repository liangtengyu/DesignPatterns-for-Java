package abstractFactory;

import abstractFactory.color.ColorFactory;
import factoryMethod.factorys.ColaFactory;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:41
 */
public abstract class ColaAbstractFactory {
    abstract ColaFactory getCola(String cola);
    abstract ColorFactory getColor(String color);
}
