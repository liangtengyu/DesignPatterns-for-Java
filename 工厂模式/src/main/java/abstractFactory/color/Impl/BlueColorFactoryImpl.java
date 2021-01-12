package abstractFactory.color.Impl;

import abstractFactory.color.ColorFactory;

/**
 * @Author: lty
 * @Date: 2021/1/12 14:54
 */
public class BlueColorFactoryImpl implements ColorFactory {
    public String getColor() {
        System.out.println("喷涂蓝色");
        return "蓝色瓶子";
    }
}
