package factory;

import concrete.ConcreteStrategyA;
import concrete.ConcreteStrategyB;
import strategy.Strategy;

import java.util.HashMap;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:18
 * 实际的策略类是无状态的 可以使用提前生成的方式.
 */
public class StrategyFactory {
    private static final HashMap<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public  static Strategy getStrategy(String tyep) {
        Strategy strategy = strategies.get(tyep);
        return strategy;
    }
}
