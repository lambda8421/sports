package com.mofei.sports.web.service;

import com.mofei.sports.web.entity.User;

import java.util.List;


public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id);
}
