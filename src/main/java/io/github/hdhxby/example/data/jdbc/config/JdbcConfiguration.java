package io.github.hdhxby.example.data.jdbc.config;

import io.github.hdhxby.example.data.commons.entity.Audit;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.mybatis.NamespaceStrategy;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.MyBatisJdbcConfiguration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

@EnableJdbcAuditing
@EnableJdbcRepositories("io.github.hdhxby.example.data.jdbc.repository")
@Configuration
public class JdbcConfiguration {//extends AbstractJdbcConfiguration {

//    @Bean
    public NamespaceStrategy namespaceStrategy() {
        return new NamespaceStrategy() {
            @Override
            public String getNamespace(Class<?> domainType) {
                return "io.github.hdhxby.example.data.repository.mapper" + domainType.getSimpleName() + "Mapper";
            }
        };
    }

    public BeforeSaveCallback<Audit> beforeSaveCallback() {
        return (audit, mutableAggregateChange) -> {
//                audit.setId();
            return audit;
        };
    }

//    @Bean
//    DataSource dataSource() {
//
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.H2).build();
//    }
//
//    @Bean
//    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
//        return new NamedParameterJdbcTemplate(dataSource);
//    }
//
//    @Bean
//    TransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
}
