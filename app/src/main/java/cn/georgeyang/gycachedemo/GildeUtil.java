package cn.georgeyang.gycachedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.Serializable;

import cn.georgeyang.gycache.GYCacheManager;
import cn.georgeyang.gycache.util.KeyUtil;

/**
 * Created by george.yang on 17/3/16.
 */

public class GildeUtil {
    private static final int placeholder = R.mipmap.ic_launcher;
    private static int maxImagePixel = -1;

    /**
     * 加载图片，尺寸跟随变化
     * @param context
     * @param imageUrl
     * @param imageView
     */
    public static void drLoadSingleImage(Context context , final String imageUrl , final ImageView imageView){
            imageView.setImageResource(placeholder);

            if (maxImagePixel<=0) {
                DisplayMetrics metrics = imageView.getContext().getResources().getDisplayMetrics();
                maxImagePixel = (int) (metrics.widthPixels * 0.618f);     // 屏幕宽度（像素）
            }

            final String cacheKey = KeyUtil.getCacheKey(imageUrl);
            int[] picSize = GYCacheManager.get(Serializable.class, cacheKey);
            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            if (picSize!=null) {
                int width = picSize[0];
                int height = picSize[1];
                if (width>height) {//宽图
                    float size =  maxImagePixel * 1f / width;
                    params.width = maxImagePixel;
                    params.height = (int) (height * size);
                } else {
                    float size = maxImagePixel * 1f / height;
                    params.width = (int) (width * size);
                    params.height = maxImagePixel;
                }
            } else {
                //默认比例
                params.width = 400;
                params.height = 400;
            }
            imageView.setLayoutParams(params);


            Glide.with(context).load(imageUrl).asBitmap().placeholder(placeholder)
                    .error(placeholder).into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    imageView.setImageBitmap(resource);
                    int[] picSize = new int[]{resource.getWidth(),resource.getHeight()};
                    GYCacheManager.setInThread(Serializable.class, cacheKey,picSize);
                }
            });
    }
}
