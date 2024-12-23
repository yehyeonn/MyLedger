package com.lec.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return web -> web.ignoring().anyRequest();  // 어떠한 request 도 Security 가 무시함.
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/login", "/home", "/user/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/user/login")
                        .loginProcessingUrl("/user/login")
                        .successHandler(new CustomLoginSuccess("/home"))
                        .failureHandler(new CustomLoginFail())
                )
                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutUrl("/user/logout")
                        .logoutSuccessUrl("/home")
                        .invalidateHttpSession(false)
                        .logoutSuccessHandler(new CustomLogoutSuccess())
                )
                .exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer
                        .accessDeniedHandler(new AccessDenied())
                )
//                .oauth2Login(httpSecurityOAuth2LoginConfigurer -> httpSecurityOAuth2LoginConfigurer
//                        .loginPage("/user/login")    // 로그인 페이지를 기존과 동일한 url 로 지정
//                        // ↑ 구글 로그인 완료된 뒤에 후처리가 필요하다!
//
//                        .successHandler(customAuthenticationSuccessHandler)
//                        // code 를 받아오는 것이 아니라, 'AccessToken' 과 사용자 '프로필정보'를 한번에 받아온다
//                        .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
//                                // 인증서버의 userinfo endpoint 설정
//                                .userService(principalOauth2UserService)  // userService(OAuth2UserService)
//                        )
//                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
