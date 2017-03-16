package cn.georgeyang.gycachedemo;

import android.app.Application;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.URLConnectionNetworkExecutor;
import com.yanzhenjie.nohttp.cache.DBCacheStore;
import com.yanzhenjie.nohttp.cookie.DBCookieStore;

import cn.georgeyang.gycache.CacheConfig;
import cn.georgeyang.gycache.GYCacheManager;
import cn.georgeyang.gycache.impl.ACacheImpl;
import cn.georgeyang.gycache.impl.LruCacheImpl;
import cn.georgeyang.gycache.impl.SPLimitCacheImpl;

/**
 * Created by george.yang on 17/3/12.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this, new NoHttp.Config()
                .setCacheStore(
                        // 保存到数据库
                        new DBCacheStore(this).setEnable(true) // 如果不使用缓存，设置false禁用。
                        // 或者保存到SD卡：new DiskCacheStore(this)
                )
                // 设置全局连接超时时间，单位毫秒
                .setConnectTimeout(30 * 1000)
                // 设置全局服务器响应超时时间，单位毫秒
                .setReadTimeout(30 * 1000)
                // 默认保存数据库DBCookieStore，开发者也可以自己实现CookieStore接口。
                .setCookieStore(
                        new DBCookieStore(this).setEnable(false) // 如果不维护cookie，设置false禁用。
                )
                .setNetworkExecutor(new URLConnectionNetworkExecutor())
        );

        int maxMemory = (int) (Runtime.getRuntime().maxMemory()
                / 1024);
        // Use 1/4th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 4;

        CacheConfig cacheConfig = new CacheConfig();
        cacheConfig.setMaxCount(200).setMaxMemory(cacheSize).setMaxTotalSize(1000);
        GYCacheManager.init(cacheConfig,new LruCacheImpl(),new SPLimitCacheImpl(this),new ACacheImpl(this));

    }
}
