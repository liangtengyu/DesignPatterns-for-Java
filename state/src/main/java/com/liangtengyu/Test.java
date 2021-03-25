package com.liangtengyu;

/**
 * @Author: lty
 * @Date: 2021/2/26 15:02
 */
public class Test {
    public static void main(String[] args) {
        MarioStateMachine marioStateMachine = new MarioStateMachine();
        marioStateMachine.obtainCape();
        System.out.println(marioStateMachine);
        marioStateMachine.meetMonster();
        System.out.println(marioStateMachine);

    }
}
