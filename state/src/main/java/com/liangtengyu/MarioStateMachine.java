package com.liangtengyu;

import static com.liangtengyu.State.CAPE;
import static com.liangtengyu.State.FIRE;
import static com.liangtengyu.State.SMALL;
import static com.liangtengyu.State.SUPER;

/**
 * @Author: lty
 * @Date: 2021/2/26 14:23
 */
public class MarioStateMachine {
    private int score;
    private State currentState;



    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    //使用逻辑方法if else来处理状态
    public void obtainMushRoom() {
        this.currentState= SUPER;
        this.score += 100;
    }


    //使用查表法实现状态处理
    private final static State transitionTable[][] = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}

    };
    private final static int actionTable[][] = {
            {100, 200, 300, 0},
            {100, 200, 300, -100},
            {0, 0, 0, -200},
            {0, 0, 0, -300}
    };

    public void obtainCape( ) {
        execution(Event.GOT_CAPE);
    }

    public void meetMonster() {
        execution(Event.MET_MASTER);
    }




    public void obtainFireFlower() {
    }




    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }


    @Override
    public String toString() {
        return "MarioStateMachine{" +
                "score=" + score +
                ", currentState=" + currentState +
                '}';
    }


    private void execution(Event event) {
        int eventValue = event.getValue();
        int stv = currentState.getValue();
        this.currentState = transitionTable[stv][eventValue];
        this.score = Math.max((this.score + actionTable[stv][eventValue]), 0);
    }
}
