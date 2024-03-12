package io.github.hdhxby.example.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 权限中心
 *
 * @author lixiaobin
 * @version 2.0, 03/06/21
 * @since 2.0
 */

@SpringBootApplication
public class JdbcRepositoryApplication {
    private static final Logger log = LoggerFactory.getLogger(JdbcRepositoryApplication.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JdbcRepositoryApplication.class);
        springApplication.setHeadless(false);
        springApplication.run(args);
    }

}
