package abstractFactory.color.Impl;

import abstractFactory.color.ColorFactory;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:54
 */
public class YellowColorFactoryImpl implements ColorFactory {
    public String getColor() {
        System.out.println("喷涂黄色");

        return "黄色瓶子";
    }
}
