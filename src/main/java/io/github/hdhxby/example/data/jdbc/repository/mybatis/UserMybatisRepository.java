package io.github.hdhxby.example.data.jdbc.repository.mybatis;

import io.github.hdhxby.example.data.commons.entity.User;

import java.util.List;

public interface UserMybatisRepository {

    List<User> selectList();
}
