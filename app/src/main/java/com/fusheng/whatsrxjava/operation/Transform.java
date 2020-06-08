package com.fusheng.whatsrxjava.operation;

import android.util.Log;

import com.fusheng.whatsrxjava.Course;
import com.fusheng.whatsrxjava.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * @author lixiaowei
 * @date:2020/4/29 14:53
 * Description:变换操作符:map、flatMap、concatMap
 */
public class Transform {

    /**qqq
     * map操作符，1对1，输入一个参数，返回一个参数
     */
    public void map() {
        Observable.just(1, 2, 3)
                .map(integer -> String.format("前缀%s", integer))
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
     * 1对1或者1对多的转换形式，转换后发射，接收事件无序,发射事件少的话，看不出来，事件多的话就能看出无序了
     */
    public void flatMap() {
        List<Student> studentList = generateStudent();
        Observable.fromIterable(studentList)
                .flatMap((Function<Student, ObservableSource<Course>>) student -> Observable.fromIterable(student.getCourseList()))
                .subscribe(new Observer<Course>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Course course) {
                        Log.d("lixiaowei", "onNext------" + course.getName() + "------" + course.getScore());
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
     * 功能和flatMap基本一致，区别是接收事件有序
     */
    public void concatMap() {
        List<Student> studentList = generateStudent();
        Observable.fromIterable(studentList)
                .concatMap((Function<Student, ObservableSource<Course>>) student -> Observable.fromIterable(student.getCourseList()))
                .subscribe(new Observer<Course>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("lixiaowei", "onSubscribe------" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Course course) {
                        Log.d("lixiaowei", "onNext------" + course.getName() + "------" + course.getScore());
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

    private List<Student> generateStudent() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("张三", generateCourseList(1)));
        studentList.add(new Student("李四", generateCourseList(2)));
        studentList.add(new Student("王五", generateCourseList(3)));
        return studentList;
    }

    private List<Course> generateCourseList(int type) {
        List<Course> list = new ArrayList<>();
        if (type == 1) {
            list.add(new Course("chinese", "76"));
            list.add(new Course("english", "80"));
        } else if (type == 2) {
            list.add(new Course("chinese", "88"));
            list.add(new Course("math", "99"));
        } else if (type == 3) {
            list.add(new Course("math", "30"));
            list.add(new Course("english", "40"));
        }
        return list;
    }
}
