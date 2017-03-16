package cn.georgeyang.gycache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存外壳
 * Created by george.yang on 17/3/12.
 */
public class GYCacheManager {
    public static final int Version = 1;
    private static CacheConfig cacheConfig;
    private static CacheImpl[] cacheImpls;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    /**
     * 初始化
     * @param config 统一的缓存配置
     * @param caches
     */
    public static void init (CacheConfig config, CacheImpl... caches) {
        cacheConfig = config;
        cacheImpls = caches;
        for (CacheImpl impl:cacheImpls) {
            impl.setCacheConfig(cacheConfig);
        }
    }

    public static  <T> T get (Class type,String key) {
        T ret = null;
        for (int i = 0; i < cacheImpls.length; i++) {
            CacheImpl impl = cacheImpls[i];
            Object t = impl.get(type,key);
            if (t != null) {
                ret = (T) t;
                //给前面没有获取到缓存的impl设置缓存
                for (int j = 0; j < i; j++) {
                    CacheImpl implGetNull = cacheImpls[j];
                    try {
                        implGetNull.set(type,key,ret);
                        implGetNull.commit(type,key);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
        return ret;
    }

    public static void setInThread (Class type,String key,Object value) {
        executorService.execute(new SetDataRunnable(type,key,value));
    }

    private static class SetDataRunnable implements Runnable {
        private String key;
        private Object value;
        private Class type;
        SetDataRunnable (Class type,String key,Object value) {
            this.key = key;
            this.value = value;
            this.type = type;
        }
        @Override
        public void run() {
            GYCacheManager.set(type,key,value);
        }
    }

    public static boolean set (Class type,String key,Object value) {
        for (int i = 0; i < cacheImpls.length; i++) {
            int currIndex = cacheImpls.length - 1 - i;
            CacheImpl cacheImpl = cacheImpls[currIndex];
            try {
                cacheImpl.set(type,key,value);
            } catch (Exception e) {
                for (int j = currIndex; j < cacheImpls.length; j++) {
                    cacheImpl.rollback(type,key);
                }
            }
        }
        for (CacheImpl impl:cacheImpls) {
            impl.commit(type,key);
        }
        return true;
    }


}
