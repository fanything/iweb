package com.we.demo.designmode.bridge;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/2 10:27
 */
public class StandardWatch extends IWatch{

    public StandardWatch(Iwatchband iwatchband) {
        super(iwatchband);
    }

    @Override
    public void init() {
        iwatchband.setBand();
        System.out.println("这是一个标准版IWatch");
    }
}
