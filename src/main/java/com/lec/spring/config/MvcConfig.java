package com.lec.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    public static class LocalMvcConfiguration implements WebMvcConfigurer {

        // 파일 업로드
        // resource 경로 추가
        @Value("${app.upload.path}")
        private String uploadDir;

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            System.out.println("LocalMvcConfiguration.addResourceHandlers() 호출");
            registry
                    .addResourceHandler("/upload/**")
                    .addResourceLocations("file:" + uploadDir + "/");
        }
    }


}
