package com.fusheng.whatsrxjava.operation;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author lixiaowei
 * @ date:2020/4/29 11:48
 * Description:RxJava创建操作符
 */
public class Create {
    /**
     * create操作符是最原始的创建型操作符，需要开发者自己发射事件
     */
    public void create() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d("lixiaowei", "onNext------" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("lixiaowei", "onComplete------");
            }
        });
    }

    /**
     * just是自己内部发射事件，无需开发者发射，参数个数固定，最多10个参数
     */
    public void just() {
        Observable.just(1, 2, 3).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
            }

            @Override
            public void onNext(Integer integer) {
                Log.d("lixiaowei", "onNext------" + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("lixiaowei", "onComplete------");
            }
        });
    }

    /**
     * range是自己内部发射事件，无需开发者发射，接受两个参数，第一个是开始数字，第二个是增加的次数，并非是结束的数值哦
     */
    public void range() {
        Observable.range(31, 4)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("lixiaowei", "onNext------" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("lixiaowei", "onError------");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

    /**
     * fromArray是自己内部发射事件，无需开发者发射，参数为一个数组；这个方法和 just() 类似
     */
    public void fromArray() {
        String[] strings = {"A", "B", "C"};
        Observable.fromArray(strings)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("lixiaowei", "onNext------" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

    /**
     * 发射一个可迭代的集合，譬如List
     */
    public void fromIterable() {
        List<String> testList = new ArrayList<>();
        testList.add("q");
        testList.add("w");
        testList.add("e");
        testList.add("r");
        Observable.fromIterable(testList)
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("lixiaowei", "onNext------" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

    /**
     * empty只会调用onSubscribe和onComplete两个方法；下游默认是Object，无法发出有值事件，只会发射 onComplete，简化版的Consumer不会收到事件。
     */
    public void empty() {
        Observable.empty()
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Object o) {
                        Log.d("lixiaowei", "onNext------" + o);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

    /**
     * 延迟指定时间发射数据
     */
    public void timer() {
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("lixiaowei", "onNext------" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

    /**
     * 可以延迟指定时间，并以指定周期发射事件,无限循环
     * initialDelay:开始延迟事件
     * period:发射事件周期
     * 初始延迟3s,每隔1s发射一个事件
     */
    public void interval() {
        Observable.interval(3, 1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("lixiaowei", "onNext------" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

    /**
     * 可以延迟指定时间，并以指定周期发射事件
     * star:开始数字
     * count:增加数字的个数
     * initialDelay:开始延迟事件
     * period:发射事件周期
     * 初始延迟3s,从4开始增加5个数字，每隔1s发增加一次
     */
    public void intervalRange() {
        Observable.intervalRange(4, 5, 3, 1, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("lixiaowei", "onNext------" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("lixiaowei", "onComplete------");
                    }
                });
    }

}
