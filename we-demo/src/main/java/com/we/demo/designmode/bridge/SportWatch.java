package com.we.demo.designmode.bridge;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/2 10:27
 */
public class SportWatch extends IWatch{

    public SportWatch(Iwatchband iwatchband) {
        super(iwatchband);
    }

    @Override
    public void init() {
        iwatchband.setBand();
        System.out.println("这是一个运动版IWatch");
    }
}
