package com.fusheng.whatsrxjava;

import android.app.Application;
import android.content.Context;

import com.argusapm.android.api.Client;
import com.argusapm.android.core.Config;
import com.argusapm.android.network.cloudrule.RuleSyncRequest;
import com.argusapm.android.network.upload.CollectDataSyncUpload;

/**
 * @author lixiaowei
 * @date 2020/7/1 11:47
 * Description:
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Config.ConfigBuilder builder = new Config.ConfigBuilder()
                .setAppContext(this)
                .setAppName("WhatsRxJava")
                .setRuleRequest(new RuleSyncRequest())
                .setUpload(new CollectDataSyncUpload())
                .setAppVersion("1.0")
                .setApmid("WhatsRxJava");
        Client.attach(builder.build());
        Client.startWork();
    }
}
