package com.liangtengyu.entity;

import com.liangtengyu.command.Command;

/**
 * @Author: lty
 * @Date: 2021/4/1 09:54
 */
public class EndGame implements Command {

    private String data;
    public EndGame(String data) {
        System.out.println("接收到数据:"+data);
        this.data= data;
    }

    @Override
    public void execute() {
        System.out.println(this.getClass().getName()+"操作数据"+data);
    }


}
