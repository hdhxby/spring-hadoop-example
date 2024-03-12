package io.github.hdhxby.example.data.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SqlSessionFactoryBeanCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class ThinkSqlSessionFactoryBeanCustomizer implements SqlSessionFactoryBeanCustomizer {

    private static final Logger log = LoggerFactory.getLogger(ThinkSqlSessionFactoryBeanCustomizer.class);

    @Override
    public void customize(SqlSessionFactoryBean factoryBean) {

    }
}
