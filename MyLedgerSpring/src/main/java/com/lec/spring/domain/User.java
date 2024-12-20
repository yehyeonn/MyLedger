package com.lec.spring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    @ToString.Exclude
    private String re_password;

    private String nickname;
    private String profile_img;
    private String currency;
}
