package com.we.demo.designmode.bridge;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/2 10:18
 */
public abstract class IWatch {

    protected Iwatchband iwatchband;

    public IWatch(Iwatchband iwatchband) {
        this.iwatchband = iwatchband;
    }

    public abstract void init();
}
