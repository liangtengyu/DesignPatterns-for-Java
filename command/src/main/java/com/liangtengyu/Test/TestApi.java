package com.liangtengyu.Test;

import com.liangtengyu.command.Command;
import com.liangtengyu.entity.EndGame;
import com.liangtengyu.entity.PauseGame;
import com.liangtengyu.entity.StartGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/4/1 09:59
 */
public class TestApi {
    public static void main(String[] args) {
        //首先组装模拟请求序列
        Command startGame = new StartGame("user:lty");
        Command pause = new PauseGame("user:lty");
        Command endGame = new EndGame("user:lty");

        List<Command> command = new ArrayList<>();
        command.add(startGame);
        command.add(pause);
        command.add(endGame);

        //组装模拟请求完毕后,开始模拟execute
        for (Command command1 : command) {
            command1.execute();
        }



    }
}
