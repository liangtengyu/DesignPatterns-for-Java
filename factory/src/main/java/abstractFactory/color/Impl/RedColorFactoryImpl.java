package abstractFactory.color.Impl;

import abstractFactory.color.ColorFactory;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:54
 */
public class RedColorFactoryImpl implements ColorFactory {
    public String getColor() {
        System.out.println("喷涂红色");
        return "红色瓶子";
    }
}
