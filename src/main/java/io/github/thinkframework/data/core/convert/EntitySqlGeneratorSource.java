package io.github.thinkframework.data.core.convert;

import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.util.Assert;
import org.springframework.util.ConcurrentReferenceHashMap;

import java.util.Map;

/**
 * 缓存EntitySqlGenerator
 * @see org.springframework.data.jdbc.core.convert.SqlGeneratorSource
 * @author lixiaobin
 */
public class EntitySqlGeneratorSource {

    private final Map<Class<?>, EntitySqlGenerator> CACHE = new ConcurrentReferenceHashMap<>();
    private final RelationalMappingContext context;
    private final JdbcConverter converter;
    private final Dialect dialect;

    public EntitySqlGeneratorSource(RelationalMappingContext context, JdbcConverter converter, Dialect dialect) {

        Assert.notNull(context, "Context must not be null.");
        Assert.notNull(converter, "Converter must not be null.");
        Assert.notNull(dialect, "Dialect must not be null.");

        this.context = context;
        this.converter = converter;
        this.dialect = dialect;
    }

    /**
     * @return the {@link Dialect} used by the created {@link SqlGenerator} instances. Guaranteed to be not
     *         {@literal null}.
     */
    public Dialect getDialect() {
        return dialect;
    }

    public EntitySqlGenerator getSqlGenerator(Class<?> domainType) {

        return CACHE.computeIfAbsent(domainType,
                t -> new EntitySqlGenerator(context, converter, context.getRequiredPersistentEntity(t), dialect));
    }
}
