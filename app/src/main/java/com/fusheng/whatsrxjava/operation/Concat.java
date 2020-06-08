package com.fusheng.whatsrxjava.operation;

import android.util.Log;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;

/**
 * @author lixiaowei
 * @date:2020/6/8 19:56
 * Description:合并操作符,只记录常用的(zip、concat、merge)
 */
public class Concat {

    /**
     * 合并两个事件，合并后最终结果的数目，和结果集少的那个相同。多余的数据会在合并后被抛弃。
     * 适用于2个网络请求，当每个都请求成功后，统一处理数据
     * 2个事件用BiFunction
     */
    public void zip() {
        Observable<Integer> just1 = Observable.just(1, 3, 5, 7);
        Observable<Integer> just2 = Observable.just(2, 4, 6, 8, 10);
        Disposable d = Observable.zip(just1, just2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer i1, Integer i2) throws Exception {
                return String.format("%s--%s--%s", String.valueOf(i1), String.valueOf(i2), String.valueOf(new Date()));
            }
        })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d("lixiaowei", "accept: " + s);
                    }
                });
    }

    /**
     * 合并3~9个事件合并，合并后最终结果的数目，和结果集少的那个相同。多余的数据会在合并后被抛弃。
     * 3~9个事件以上用Function3~9
     */
    public void multiZip() {
        Observable<Integer> just1 = Observable.just(1, 3, 5, 7);
        Observable<Integer> just2 = Observable.just(2, 4, 6, 8, 10);
        Observable<Integer> just3 = Observable.just(11, 22, 33, 44, 55);
        Disposable d = Observable.zip(just1, just2, just3, (i1, i2, i3) -> String.format("%s--%s--%s", String.valueOf(i1), String.valueOf(i2),
                String.valueOf(i3))).subscribe(s -> Log.d("lixiaowei", "accept: " + s));
    }

    /**
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 1
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 3
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 5
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 2
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 4
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 6
     * 2020-06-08 21:14:03.263 21135-21135/com.fusheng.whatsrxjava D/lixiaowei: concat: 8
     * 依次发送，发送完一个再接着发送第二个
     * <p>
     * 入参是可变参数，支持多个observable发射，依次发射，依次接收
     */
    public void concat() {
        Observable<Integer> just1 = Observable.just(1, 3, 5);
        Observable<Integer> just2 = Observable.just(2, 4, 6, 8);
        Disposable d = Observable.concat(just1, just2)
                .subscribe(c -> Log.d("lixiaowei", "concat: " + c));
    }


    /**
     * 合并两个事件，合并后数据可能是交错的，数据量少可能看不出来
     */
    public void merge() {
        Observable<Integer> just1 = Observable.just(1, 3, 5, 7);
        Observable<Integer> just2 = Observable.just(2, 4, 6, 8, 10);
        Disposable d = Observable.merge(just1, just2)
                .subscribe(integer -> Log.d("lixiaowei", "accept: " + integer));
    }

}
