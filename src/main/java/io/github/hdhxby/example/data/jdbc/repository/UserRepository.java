package io.github.hdhxby.example.data.jdbc.repository;

import io.github.hdhxby.example.data.commons.entity.User;
import io.github.thinkframework.data.mybatis.repository.query.MybatisQueryByExampleExecutor;
import io.github.hdhxby.example.data.jdbc.repository.mybatis.UserMybatisRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> { //, MybatisQueryByExampleExecutor<User>, UserMybatisRepository {

    List<User> findByName(@Param("name") String name);

    @Query("select * from user")
    List<User> query();
}
