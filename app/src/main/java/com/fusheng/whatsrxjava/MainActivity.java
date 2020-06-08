package com.fusheng.whatsrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.fusheng.whatsrxjava.operation.Concat;
import com.fusheng.whatsrxjava.operation.Create;
import com.fusheng.whatsrxjava.operation.Function;
import com.fusheng.whatsrxjava.operation.Transform;
import com.fusheng.whatsrxjava.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Create create = new Create();
       /* Transform transform = new Transform();
        Function function = new Function();*/
        Concat concat = new Concat();
        findViewById(R.id.tv_click).setOnClickListener(v -> concat.zip());
    }

    private void delay() {
        Observable.just("t", "y", "p")
                .delay(3, TimeUnit.SECONDS)
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


    public static List<Student> generateStudentList() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            List<Course> courseList = new ArrayList<>();
            courseList.add(new Course("语文", RandomUtils.randowInt()));
            courseList.add(new Course("数学", RandomUtils.randowInt()));
            courseList.add(new Course("英语", RandomUtils.randowInt()));
            Student student = new Student(String.format("学生%s", String.valueOf(i)), courseList);
            studentList.add(student);
        }
        return studentList;
    }

}
