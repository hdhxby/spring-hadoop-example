package io.github.hdhxby.example.data.jdbc.config;

import io.github.hdhxby.example.data.config.ThinkConfigurationCustomizer;
import io.github.hdhxby.example.data.config.ThinkSqlSessionFactoryBeanCustomizer;
import io.github.thinkframework.data.ibatis.session.EntityConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SqlSessionFactoryBeanCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Import(MyBatisJdbcConfiguration.class)
@MapperScan(basePackages = {"io.github.hdhxby.example.data.jdbc.repository.mapper","io.github.hdhxby.example.data.commons.entity"})
@Configuration
public class MybatisConfiguration {
//    @Primary
//    @Bean
//    public MybatisProperties mybatisProperties() {
//        return new MybatisProperties(){
//            @Override
//            public org.apache.ibatis.session.Configuration getConfiguration() {
//                return new EntityConfiguration();
//            }
//        };
//    }
//
    @Bean
    public ConfigurationCustomizer thinkConfigurationCustomizer() {
        return new ThinkConfigurationCustomizer();
    }

    @Bean
    public SqlSessionFactoryBeanCustomizer thinkSqlSessionFactoryBeanCustomizer() {
        return new ThinkSqlSessionFactoryBeanCustomizer();
    }
}
