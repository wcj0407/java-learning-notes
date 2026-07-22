package org.example.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springbootdemo.pojo.user;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public  List<user> findAll();
}
