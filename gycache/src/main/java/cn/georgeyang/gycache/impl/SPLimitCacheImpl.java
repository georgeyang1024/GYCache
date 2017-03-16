package cn.georgeyang.gycache.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.io.Serializable;

import cn.georgeyang.gycache.CacheConfig;
import cn.georgeyang.gycache.CacheImpl;
import cn.georgeyang.gycache.util.ObjectUtil;

/**
 * SharedPreferences key限制缓存
 * Created by george.yang on 17/3/12.
 */
public class SPLimitCacheImpl implements CacheImpl {
    private SharedPreferences sharedPreferences;
    private int maxCount = 100;
    public SPLimitCacheImpl(Context context) {
        sharedPreferences = context.getSharedPreferences("SPLimitCache",Context.MODE_PRIVATE);
    }
    @Override
    public void setCacheConfig(CacheConfig config) {
        maxCount = Math.min(100,config.getMaxCount());
    }

    @Override
    public boolean set(Class type,String key, Object value) throws Exception {
        if (value instanceof Serializable) {
            if (sharedPreferences.getAll().size()>maxCount) {
                sharedPreferences.edit().clear().commit();
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, ObjectUtil.toString((Serializable) value));
            return editor.commit();
        } else {
            return false;
        }
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
    public Object get(Class type,String key) {
        Object value = null;
        String str = sharedPreferences.getString(key,"");
        if (!TextUtils.isEmpty(str)) {
            try {
                value = ObjectUtil.fromString(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    @Override
    public boolean remove(Class type, String key) {
        sharedPreferences.edit().remove(key).commit();
        return false;
    }

    @Override
    public boolean clear(Class type) {
        sharedPreferences.edit().clear().commit();
        return false;
    }
}
