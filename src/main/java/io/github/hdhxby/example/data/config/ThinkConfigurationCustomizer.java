package io.github.hdhxby.example.data.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class ThinkConfigurationCustomizer implements ConfigurationCustomizer {

    private static final Logger log = LoggerFactory.getLogger(ThinkConfigurationCustomizer.class);

    @Override
    public void customize(Configuration configuration) {
        configuration.getCaches().stream().forEach(cache -> {

        });
    }
}
