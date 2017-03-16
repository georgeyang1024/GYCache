package cn.georgeyang.gycache.impl;

import cn.georgeyang.gycache.CacheConfig;
import cn.georgeyang.gycache.CacheImpl;
import cn.georgeyang.gycache.cache.LruCache;

/**
 * Created by yangsp on 2016/10/11.
 */
public class LruCacheImpl implements CacheImpl
{
    private LruCache lruCache;
    @Override
    public void setCacheConfig(CacheConfig config) {
        lruCache = new LruCache(config.getMaxMemory());
    }

    @Override
    public boolean set(Class type,String key, Object value) throws Exception {
        lruCache.put(key,value);
        return true;
    }

    @Override
    public boolean rollback(Class type,String key) {
        return true;
    }

    @Override
    public boolean commit(Class type,String key) {
        return true;
    }

    @Override
    public Object get(Class type,String key) {
        Object object = lruCache.get(key);
        return object;
    }

    @Override
    public boolean remove(Class type, String key) {
        lruCache.remove(key);
        return false;
    }

    @Override
    public boolean clear(Class type) {
        lruCache.evictAll();
        return false;
    }
}
