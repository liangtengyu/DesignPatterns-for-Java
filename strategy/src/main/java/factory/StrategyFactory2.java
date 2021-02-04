package factory;

import concrete.ConcreteStrategyA;
import concrete.ConcreteStrategyB;
import strategy.Strategy;

import java.util.HashMap;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:18
 * 实际的策略类是有状态的,每次都要创建新的对象时,使用此方式
 */
public class StrategyFactory2 {
    private static final HashMap<String, Class> strategies = new HashMap<>();

    static {
        strategies.put("A", ConcreteStrategyA.class);
        strategies.put("B", ConcreteStrategyB.class);
    }

    //通过反射方式,创建新对象,, 或者可以通过new的方式来创建对象,避免了使用if else
    public  static Strategy getStrategy(String tyep) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = strategies.get(tyep);
        Strategy o = (Strategy) aClass.newInstance();
        return o;
    }
}
