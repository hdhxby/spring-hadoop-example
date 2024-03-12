package io.github.thinkframework.data.ibatis.session;

import org.apache.ibatis.binding.MapperRegistry;
import io.github.thinkframework.data.ibatis.binding.EntityMapperRegistry;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

/**
 * 将MapperRegistry替换为EntityMapperRegistry
 * @see EntityMapperRegistry
 * @see org.apache.ibatis.binding.MapperRegistry
 * @see org.apache.ibatis.session.Configuration
 */
public class EntityConfiguration extends Configuration {
    protected final MapperRegistry mapperRegistry = new EntityMapperRegistry(this);

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }

    public void addMappers(String packageName, Class<?> superType) {
        mapperRegistry.addMappers(packageName, superType);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }
}
