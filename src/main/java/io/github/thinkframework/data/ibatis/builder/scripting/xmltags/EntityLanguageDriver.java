package io.github.thinkframework.data.ibatis.builder.scripting.xmltags;

import io.github.thinkframework.data.core.convert.EntitySqlGenerator;
import io.github.thinkframework.data.core.convert.EntitySqlGeneratorSource;
import io.github.thinkframework.data.mybatis.mapper.EntityMapper;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.springframework.data.jdbc.core.convert.*;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;
import org.springframework.data.mapping.PersistentPropertyPath;
import org.springframework.data.relational.core.dialect.MySqlDialect;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.data.relational.core.mapping.RelationalPersistentProperty;

import java.lang.reflect.*;

/**
 * createSqlSource添加mapperType, mapperMethod参数
 *
 * @ss org.apache.ibatis.scripting.xmltags.XMLLanguageDriver
 */
public class EntityLanguageDriver extends XMLLanguageDriver {

    /**
     *
     * @param configuration
     * @param script
     * @param parameterType
     * @param mapperType Mapper类
     * @param mapperMethod Mapper方法
     * @return
     */
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType, Class<?> mapperType, Method mapperMethod) {
        // 自定义逻辑
        if(EntityMapper.class.isAssignableFrom(mapperType)) {
            Type[] genericInterfaces = mapperType.getGenericInterfaces();
            if (genericInterfaces != null && genericInterfaces.length > 0) {
                ParameterizedType parameterizedType = ((ParameterizedType) mapperType.getGenericInterfaces()[0]);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                    EntitySqlGenerator sqlGenerator = getSqlGenerator((Class<?>) actualTypeArguments[0]);
                    try {
                        Method sql = EntitySqlGenerator.class.getMethod(mapperMethod.getName());
                        script = (String) sql.invoke(sqlGenerator);
                    }  catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }  catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        }
        return super.createSqlSource(configuration, script, parameterType);
    }

    public EntitySqlGenerator getSqlGenerator(Class<?> type) {
        RelationalMappingContext relationalMappingContext = new JdbcMappingContext();
        JdbcConverter jdbcConverter = new BasicJdbcConverter(relationalMappingContext, new RelationResolver() {
            @Override
            public Iterable<Object> findAllByPath(Identifier identifier, PersistentPropertyPath<? extends RelationalPersistentProperty> path) {
                return null;
            }
        });
        EntitySqlGeneratorSource sqlGeneratorSource = new EntitySqlGeneratorSource(relationalMappingContext, jdbcConverter, MySqlDialect.INSTANCE);
        return sqlGeneratorSource.getSqlGenerator(type);
    }
}
