package cn.georgeyang.gycache.util;

import android.text.TextUtils;

/**
 * Created by george.yang on 17/3/12.
 */

public class KeyUtil {
    public static String getCacheKey (String url) {
        if (TextUtils.isEmpty(url) || url.length()<=2) return "";
        int h = url.length()/2;
        String key = url.substring(0,h).hashCode() + "#" + url.substring(h,url.length()).hashCode();
        return key;
    }
}
