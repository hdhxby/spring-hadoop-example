package io.github.hdhxby.example.data.jdbc.repository.impl;

import io.github.hdhxby.example.data.commons.entity.User;
import io.github.thinkframework.data.mybatis.repository.query.MybatisQueryByExampleExecutor;
import io.github.hdhxby.example.data.commons.entity.UserMapper;
import io.github.hdhxby.example.data.jdbc.repository.mybatis.UserMybatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UserRepositoryImpl implements UserMybatisRepository, MybatisQueryByExampleExecutor<User> {

//    @Autowired
    private JdbcTemplate sqlSessionTemplate;

//    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectList() {
        return null; //helloMapper1.selectList(); // sqlSessionTemplate.queryForList("select * from hello", Hello.class);
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> Iterable<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
