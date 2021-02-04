package concrete;

import strategy.Strategy;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:16
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("使用具体算法A");
    }
}
