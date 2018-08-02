package com.we.demo.designmode.bridge;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/2 10:22
 */
public class MetalBand implements Iwatchband{
    @Override
    public void setBand() {
        System.out.println("这是一个合金表带");
    }
}
