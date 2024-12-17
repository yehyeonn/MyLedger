package com.lec.spring.service;

import com.lec.spring.domain.User;

public interface UserService {
    User findByUsername(String username);

    User findById(Long id);

    boolean isExist(String username);
    // TODO
}
