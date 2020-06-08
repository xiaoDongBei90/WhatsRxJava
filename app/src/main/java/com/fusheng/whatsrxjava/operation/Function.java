package com.fusheng.whatsrxjava.operation;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * @author lixiaowei
 * @date:2020/6/4 20:47
 * Description:
 */
public class Function {

    /**
     * 过滤时间，当条件不满足时，下游不会收到任何事件
     */
    public void filter() {
        Observable.just(1, 2, 3, 4)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 4;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d("lixiaowei", "accept: " + integer);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("lixiaowei", "accept: " + throwable.toString());
                    }
                });
    }
}
