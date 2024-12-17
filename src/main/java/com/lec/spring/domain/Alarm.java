package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alarm {
    private Long id;
    private Long user_id;
    private Integer percent;
    private String type;
    private String message;
}
