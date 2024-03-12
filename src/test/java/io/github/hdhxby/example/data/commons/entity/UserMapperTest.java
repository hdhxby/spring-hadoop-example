package io.github.hdhxby.example.data.commons.entity;

import io.github.hdhxby.example.data.JdbcRepositoryApplication;
import io.github.hdhxby.example.data.commons.repository.criteria.UserCriteria;
//import io.github.thinkframework.commons.repository.filter.IntegerFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest(classes = {JdbcRepositoryApplication.class})
public class UserMapperTest {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    public void setup() {
        User user = new User();
        user.setId(1L);
        user.setName("hello");
    }

    @Test
    public void test() {
//        UserCriteria userCriteria = new UserCriteria();
//        IntegerFilter age = new IntegerFilter();
//        age.setIn(Stream.of(1).collect(Collectors.toList()));
//        userCriteria.setAge(age);
//        userMapper.selectList(userCriteria);
    }
    @AfterEach
    public void tairdown() {
    }
}
