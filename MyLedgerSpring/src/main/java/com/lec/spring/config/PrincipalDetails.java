package com.lec.spring.config;

import com.lec.spring.domain.User;
import com.lec.spring.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public class PrincipalDetails implements UserDetails, OAuth2User {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private User user;
    public User getUser() {
        return this.user;
    }

    // 일반
    public PrincipalDetails(User user) {
        this.user = user;
    }

    // OAuth2
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        System.out.println("""
           UserDetails(user, oauth attributes) 생성:
               user: %s
               attributes: %s
           """.formatted(user, attributes));

        this.user = user;
        this.attributes = attributes;
    }

    private Map<String, Object> attributes; // OAuthUser 의 getAttributes() 값

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
