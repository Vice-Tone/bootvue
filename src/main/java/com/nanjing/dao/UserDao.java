package com.nanjing.dao;

import com.nanjing.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> findAll();

    void save(User user);

    void delete(String id);

    User findOne(String id);

    void update(User user);

    List<User> findLike(@Param("name") String name, @Param("phoneCode") String phoneCode);
}
