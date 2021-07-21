package com.airoucat.ssmdemo.service;

import com.airoucat.ssmdemo.entity.User;
import java.util.List;

public interface UserService {
    /**
     * 从数据库中查询出所有的User对象
     * @return User对象集合
     */
    List<User> getAll();
}