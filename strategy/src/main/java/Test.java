import factory.StrategyFactory;
import factory.StrategyFactory2;
import strategy.Strategy;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:20
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Strategy a = StrategyFactory.getStrategy("B");
        a.algorithm();

        Strategy a2 = StrategyFactory2.getStrategy("A");
        a2.algorithm();



    }
}
