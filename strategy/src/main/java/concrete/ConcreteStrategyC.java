package concrete;

import strategy.Strategy;

/**
 * @Author: lty
 * @Date: 2021/2/4 15:16
 * 使用注解方式,注册strategy实现类
 */
@annotation.Strategy(value = "C策略实现类")
public class ConcreteStrategyC implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("使用具体算法c");
    }
}
