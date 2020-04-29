package com.fusheng.whatsrxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.fusheng.whatsrxjava.operation.Create;

import java.util.ArrayList;
import java.util.List;
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
        Create create = new Create();
        findViewById(R.id.tv_click).setOnClickListener(v -> create.intervalRange());
    }

    private void delay(){
        Observable.just("t","y","p")
                .delay(3,TimeUnit.SECONDS)
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
}
