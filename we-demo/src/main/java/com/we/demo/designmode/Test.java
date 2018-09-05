package com.we.demo.designmode;

import com.iweb.common.util.BeanUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @Author:FanMingxin
 * @Date: 2018/8/4 20:39
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        Ba a = new Ba();
        a.setId(1);
        a.setTime(new Date());

        Ba b = new Ba();
        b.setAge(3);
        b.setName("b");

        BeanUtil.combineSydwCore(a, b);

        System.out.println(b);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(format.parse("2018-08-23 19:50:29").after(format.parse("2018-08-23 19:48:08")));
    }
}
