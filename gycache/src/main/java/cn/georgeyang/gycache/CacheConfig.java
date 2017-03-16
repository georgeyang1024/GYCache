package cn.georgeyang.gycache;

/**
 * 缓存配置文件
 * Created by george.yang on 17/3/12.
 */
public class CacheConfig {
    private int maxTotalSize;//总缓存文件大小，k
    private int maxCount;//缓存数量，个
    private int maxSaveMillisecond;//缓存时间，毫秒
    private int maxMemory;//占用缓存内存，k

    public int getMaxMemory() {
        return maxMemory;
    }

    public CacheConfig setMaxMemory(int maxMemory) {
        this.maxMemory = maxMemory;
        return this;
    }

    public int getMaxTotalSize() {
        return maxTotalSize;
    }

    public CacheConfig setMaxTotalSize(int maxTotalSize) {
        this.maxTotalSize = maxTotalSize;
        return this;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public CacheConfig setMaxCount(int maxCount) {
        this.maxCount = maxCount;
        return this;
    }

    public int getMaxSaveMillisecond() {
        return maxSaveMillisecond;
    }

    public CacheConfig setMaxSaveMillisecond(int maxSaveMillisecond) {
        this.maxSaveMillisecond = maxSaveMillisecond;
        return this;
    }
}
