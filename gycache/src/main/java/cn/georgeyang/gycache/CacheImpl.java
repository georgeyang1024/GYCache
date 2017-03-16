package cn.georgeyang.gycache;


/**
 * Created by george.yang on 17/3/12.
 */
public interface CacheImpl {
    void setCacheConfig(CacheConfig config);

    /**
     * 设置键值对，如果设置失败，其他缓存将会回滚
     * @param key
     * @param type 类型
     * @param value
     * @return
     */
    boolean set(Class type, String key, Object value) throws Exception;

    /**
     * 如果其他缓存操作失败，提交回滚
     * @param type 类型
     * @param key
     * @return
     */
    boolean rollback(Class type, String key);

    /**
     * 如果其他缓存都成功了，正式写入数据
     * @param type 类型
     * @param key
     * @return
     */
    boolean commit(Class type, String key);

    /**
     * 获取数据
     * @param key
     * @param type
     * @return
     */
    Object get(Class type, String key);

    /**
     * 移除一个缓存
     * @param type
     * @param key
     * @return
     */
    boolean remove (Class type,String key);

    /**
     * 清理缓存
     * @param type
     * @return
     */
    boolean clear (Class type);
}
