package cn.georgeyang.gycache.cache;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by yangsp on 2016/10/11.
 */

public class LruCache extends android.support.v4.util.LruCache<String, Object>
{
    private static LruCache instance;

    public static LruCache getInstance()
    {
        if (instance == null)
        {
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory()
                    / 1024);
            // Use 1/4th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 4;
            instance = new LruCache(cacheSize);
        }
        return instance;
    }

    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *            the maximum number of entries in the cache. For all other
     *            caches, this is the maximum sum of the sizes of the entries in
     *            this cache.
     */
    public LruCache(int maxSize)
    {
        super(maxSize);
    }

    @Override
    protected int sizeOf(String key, Object value)
    {
        if (value instanceof Bitmap) {
            Bitmap bm = (Bitmap) value;
            return bm.getRowBytes() * bm.getHeight();
        } else if (value instanceof String) {
            return value.toString().length();
        } else if (value instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) value;
            int count = animationDrawable.getNumberOfFrames();
            int size = 0;
            for (int i = 0; i < count; i++) {
                Drawable drawable = animationDrawable.getFrame(i);
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bm = ((BitmapDrawable) drawable).getBitmap();
                    size += bm.getRowBytes() * bm.getHeight();
                } else {
                    size += 2;
                }
            }
            return size;
        } else if (value instanceof String[]) {
            String[] strs = ((String[]) value);
            int size = 0;
            for (String str : strs) {
                size += str.length();
            }
            return size;
        }
        return 4;
    }


}
