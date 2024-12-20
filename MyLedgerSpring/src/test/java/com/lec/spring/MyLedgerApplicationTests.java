package com.lec.spring;

import com.lec.spring.domain.User;
import com.lec.spring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MyLedgerApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {

//        String password = userRepository.findById(2L).getPassword();
//        String passwordEnc = passwordEncoder.encode(password);
//        System.out.print(passwordEnc);

        User user = userRepository.findById(3L);

//        User user = User.builder()
//                .username("user2")
//                .password("1234")
//                .nickname("유저2")
//                .currency("KRW")
//                .build();
//        int result = userRepository.save(user);
//        System.out.println("Insert result: " + result);


    }
}
