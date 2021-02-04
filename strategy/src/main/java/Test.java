import factory.StrategyFactory;
import factory.StrategyFactory2;
import factory.StrategyFactory3;
import strategy.Strategy;

import java.io.IOException;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:20
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        Strategy a = StrategyFactory.getStrategy("B");
        a.algorithm();

        Strategy a2 = StrategyFactory2.getStrategy("A");
        a2.algorithm();



        StrategyFactory3.initial("concrete");//初始化扫描此包下的所有class 条件是要带有Strategy注解.
        Strategy s3 = StrategyFactory3.getStrategy("C策略实现类");//类名使用注解的value带入
        s3.algorithm();

    }
}
