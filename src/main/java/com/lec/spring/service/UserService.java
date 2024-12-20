package com.lec.spring.service;

import com.lec.spring.domain.User;

public interface UserService {
    User findByUsername(String username);

    User findById(Long id);

    int register(User user);

    boolean isExist(String username);

    int save(User user);

    int update(User user);
}
