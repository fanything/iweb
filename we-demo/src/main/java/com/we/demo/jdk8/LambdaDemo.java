package com.we.demo.jdk8;

import java.util.function.Supplier;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/29 15:59
 */
public class LambdaDemo {


    public <T> void action(Supplier<T> supplier){
        try {
            supplier.get();
        }catch (Exception e){

        }
    }
}
