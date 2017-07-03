package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by zeng on 2017/6/22.
 */
@Mapper
public interface UserMapper {

    public List<User> getUserList();
}
