package io.github.thinkframework.data.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import io.github.thinkframework.data.ibatis.builder.scripting.xmltags.EntityLanguageDriver;

import java.util.List;

public interface EntityMapper<ENTITY,ID> {

    @Insert({})
    @Lang(EntityLanguageDriver.class)
    int insert(ENTITY entity);

    @Update({})
    @Lang(EntityLanguageDriver.class)
    int update(ENTITY entity);

//    @Update({})
//    @Lang(EntityLanguageDriver.class)
//    int updateWithVersion(ENTITY entity);

    @Delete({})
    @Lang(EntityLanguageDriver.class)
    int delete(ENTITY entity);


//    @Delete({})
//    @Lang(EntityLanguageDriver.class)
//    int deleteWithVersion(ENTITY entity);

//    @Delete({})
//    @Lang(EntityLanguageDriver.class)
//    int deleteAll();

    @Select({})
    @Lang(EntityLanguageDriver.class)
    ENTITY findById(ID id);

    @Select({})
    @Lang(EntityLanguageDriver.class)
    List<ENTITY> findAll();

//    @Select({})
//    @Lang(EntityLanguageDriver.class)
//    List<ENTITY> findAllById(ID id);

    @Select({})
    @Lang(EntityLanguageDriver.class)
    boolean existsById(ID id);

//    @Select({})
//    List<ENTITY> findAllSorted();
//
//    @Select({})
//    Iterator<ENTITY> findAllPaged();

    @Select({})
    @Lang(EntityLanguageDriver.class)
    long count();
}
