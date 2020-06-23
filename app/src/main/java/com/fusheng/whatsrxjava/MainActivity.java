package com.fusheng.whatsrxjava;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.fusheng.whatsrxjava.operation.Concat;
import com.fusheng.whatsrxjava.operation.Create;
import com.fusheng.whatsrxjava.operation.Function;
import com.fusheng.whatsrxjava.operation.Transform;
import com.fusheng.whatsrxjava.util.RandomUtils;

import java.lang.reflect.Method;
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

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Create create = new Create();
       /* Transform transform = new Transform();
        Function function = new Function();*/
        Concat concat = new Concat();

        setWebview();
        findViewById(R.id.tv_click).setOnClickListener(v -> {
//            webView.loadUrl("https://www.baidu.com/");
            webView.loadUrl("https://cpu.baidu.com/1022/f9a56ae8?scid=62996");
            Log.d("lixiaowei", "isAllowed: ------------" + getVivoLockStatus(this));
        });
        SlideLockView slideLockView = findViewById(R.id.slide_rail);
        slideLockView.setCallback(new SlideLockView.Callback() {
            @Override
            public void onUnlock() {
                //解锁，跳转到首页
                Toast.makeText(MainActivity.this, "解锁了----", Toast.LENGTH_SHORT).show();
                Log.d("lixiaowei", "onUnlock: ------------");
            }
        });
    }

    private void setWebview() {
        webView = findViewById(R.id.webview);
//        webView.requestFocus();
        WebSettings settings = webView.getSettings();
        webView.setWebViewClient(new WebViewClient());
        settings.setJavaScriptEnabled(true);
       /* webView.setWebChromeClient(new MyWebChromeClient());
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//支持通过Javascript打开新窗口
        settings.setJavaScriptEnabled(true);//设置WebView属性，能够执行Javascript脚本
        settings.setUseWideViewPort(true);//将图片调整到适合webview的大小
        settings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        settings.setDomStorageEnabled(true);//设置是否启用了DOM Storage API
        settings.setDatabaseEnabled(true);//开启database storage API功能
        settings.setTextZoom(100); //控制字体大小不随系统设置变化
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        //对接东方头条需要设置支持三方缓存，否则会判为作弊
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }*/
    }


    class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if ((title.contains("500") && !title.contains("500彩")) || title.contains("Error") || title.contains("找不到网页") || title.contains("网页无法打开")) {
            }
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // LogUtils.d("LoadingWebView", "!--->onProgressChanged---newProgress:" + newProgress);
            super.onProgressChanged(view, newProgress);
        }

    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { // 重写此方法表明点击网页里面的链接不调用系统浏览器，而是在本WebView中显示
            String tag = "tel:";

            if (url.startsWith(tag)) {
                String mobile = url.substring(url.lastIndexOf("/") + 1);
                Uri uri = Uri.parse("tel:" + mobile);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                //这个超连接,java已经处理了，webview不要处理了
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            // LogUtils.w("LoadingWebView", "!--->onReceivedError------failingUrl： " + failingUrl);
        }

        //处理网页加载失败时
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            // LogUtils.e("LoadingWebView", "!--->onReceivedError------" );
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            // LogUtils.d("LoadingWebView", "!--->onPageFinished---url:" + url);
        }

        @Override
        public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
            // LogUtils.d("LoadingWebView", "!--->onPageStarted---url: " + s);
            super.onPageStarted(webView, s, bitmap);
        }

        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            // LogUtils.d("LoadingWebView", "!--->onReceivedSslError---");
            sslErrorHandler.proceed();
        }
    }
    /**
     * 判断vivo锁屏显示 1未开启 0开启
     *
     * @param context
     * @return
     */
    public static int getVivoLockStatus(Context context) {
        String packageName = context.getPackageName();
        Uri uri2 = Uri.parse("content://com.vivo.permissionmanager.provider.permission/control_locked_screen_action");
        String selection = "pkgname = ?";
        String[] selectionArgs = new String[]{packageName};
        try {
            Cursor cursor = context
                    .getContentResolver()
                    .query(uri2, null, selection, selectionArgs, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    int currentmode = cursor.getInt(cursor.getColumnIndex("currentstate"));
                    cursor.close();
                    return currentmode;
                } else {
                    cursor.close();
                    return 1;
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return 1;
    }

    /**
     * 判断小米手机"后台弹出界面 " 权限是否开启
     */
    private boolean isAllowed() {
        AppOpsManager ops = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        try {
            int op1 = 10020;//锁屏显示权限
            int op2 = 10021;//后台弹出界面权限
            if (ops != null) {
                Method method = ops.getClass().getMethod("checkOpNoThrow", int.class, int.class, String.class);
                Integer result = (Integer) method.invoke(ops, op1, android.os.Process.myUid(), getPackageName());
                return result != null && result == AppOpsManager.MODE_ALLOWED;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.e("lixiaowei", "not support");
        }
        return false;
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
