package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transactions {
    private Long id;
    private Long user_id;
    private Long categories_id;
    private Long amount;
    private String currency;
    private Date date;
    private String contents;
    private String type;
    private boolean is_recurring;
    private String recurrence_frequency;
}
