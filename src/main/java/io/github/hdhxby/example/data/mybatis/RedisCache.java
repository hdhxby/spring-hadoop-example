package io.github.hdhxby.example.data.mybatis;

import org.apache.ibatis.cache.Cache;

import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {

    private final String id;

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
//        redisTemplate.opsForHash().put(key, value);
    }

    @Override
    public Object getObject(Object key) {
//        redisTemplate.opsForHash().get(key);
        return null;
    }

    @Override
    public Object removeObject(Object key) {
//        return redisTemplate.opsForHash();
        return null;
    }

    @Override
    public void clear() {
//        redisTemplate
    }

    @Override
    public int getSize() {
        return 0;//(int) redisTemplate.opsForValue().size(id);
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return Cache.super.getReadWriteLock();
    }
}
