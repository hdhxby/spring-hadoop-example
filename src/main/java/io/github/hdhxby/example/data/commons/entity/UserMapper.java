package io.github.hdhxby.example.data.commons.entity;

import io.github.hdhxby.example.data.commons.repository.criteria.UserCriteria;
import io.github.thinkframework.data.mybatis.mapper.EntityMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends EntityMapper<User, Long> {

    List<User> selectList(@Param("criteria") UserCriteria criteria);

}
