package com.lec.spring.service;

import com.lec.spring.domain.User;
import com.lec.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username.toUpperCase());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public int register(User user) {
        // 기본 이미지 설정
        if (user.getProfile_img() == null || user.getProfile_img().isEmpty()) {
            String defaultProfileImage = "435a27099c2f7a977390c210a3405c66.gif";
            user.setProfile_img(defaultProfileImage);
        }

        user.setUsername(user.getUsername().toUpperCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // password 는 암호화 하여 저장
        user.setNickname(user.getNickname());
        user.setProfile_img(user.getProfile_img());
        user.setCurrency(user.getCurrency());
        userRepository.save(user);

        return 1;
    }

    @Override
    public boolean isExist(String username) {
        User user = findByUsername(username.toUpperCase());
        return user != null;
    }

    @Override
    public int save(User user) {
        userRepository.save(user);
        return 1;
    }

    @Override
    public int update(User user) {
        return userRepository.update(user);
    }

}
