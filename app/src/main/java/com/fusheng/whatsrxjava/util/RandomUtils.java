package com.fusheng.whatsrxjava.util;

import java.util.Random;

/**
 * @author lixiaowei
 * @date:2020/6/8 20:01
 * Description:
 */
public class RandomUtils {
    /**
     * 返回
     */
    public static int randowInt() {
        Random random = new Random();
        //返回随机的int值，该值介于[0,n)的区间，前闭后开
        return random.nextInt(101);
    }
}
