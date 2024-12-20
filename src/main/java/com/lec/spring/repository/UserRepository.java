package com.lec.spring.repository;

import com.lec.spring.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    User findById(Long id);

    User findByUsername(String username);

    int save(User user);

    int update(User user);
}
