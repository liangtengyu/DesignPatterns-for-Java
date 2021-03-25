package com.liangtengyu;

/**
 * @Author: lty
 * @Date: 2021/2/26 15:13
 */
public enum Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MASTER(3);

    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
