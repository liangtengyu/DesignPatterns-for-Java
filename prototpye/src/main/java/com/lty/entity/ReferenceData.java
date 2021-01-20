package com.lty.entity;

/**
 * @Author: lty
 * @Date: 2021/1/20 10:11
 */
public class ReferenceData {
    private String data;
    private String data2;

    public ReferenceData(String data, String data2) {
        this.data = data;
        this.data2 = data2;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ReferenceData{" +
                "data='" + data + '\'' +
                ", data2='" + data2 + '\'' +
                '}';
    }
}
