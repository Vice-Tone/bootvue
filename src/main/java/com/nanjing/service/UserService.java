package com.nanjing.service;

import com.nanjing.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    void delete(String id);

    User findOne(String id);

    void update(User user);

    List<User> findLike(String name, String phoneCode);
}