package cn.georgeyang.gycache.impl;

import android.content.Context;

import java.io.Serializable;

import cn.georgeyang.gycache.CacheConfig;
import cn.georgeyang.gycache.CacheImpl;
import cn.georgeyang.gycache.cache.ACache;

/**
 * Created by george.yang on 17/3/12.
 */

public class ACacheImpl implements CacheImpl {
    private Context mContext;
    private ACache aCache;
    public ACacheImpl (Context context) {
        mContext = context;
    }
    @Override
    public void setCacheConfig(CacheConfig config) {
        aCache = ACache.get(mContext.getCacheDir(),config.getMaxTotalSize(),config.getMaxCount());
    }

    @Override
    public boolean set(Class type,String key, Object value) throws Exception {
        if (value instanceof Serializable) {
            aCache.put(key, (Serializable) value);
        }
        return true;
    }

    @Override
    public boolean rollback(Class type,String key) {
        return false;
    }

    @Override
    public boolean commit(Class type,String key) {
        return false;
    }

    @Override
    public Serializable get(Class type,String key) {
        Object object = aCache.getAsObject(key);
        return (Serializable)object;
    }

    @Override
    public boolean remove(Class type, String key) {
        aCache.remove(key);
        return false;
    }

    @Override
    public boolean clear(Class type) {
        aCache.clear();
        return false;
    }
}
