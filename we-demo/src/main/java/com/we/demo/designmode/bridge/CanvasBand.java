package com.we.demo.designmode.bridge;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/2 10:22
 */
public class CanvasBand implements Iwatchband{
    @Override
    public void setBand() {
        System.out.println("这是一个帆布表带");
    }
}
