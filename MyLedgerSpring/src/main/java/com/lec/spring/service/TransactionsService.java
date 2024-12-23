package com.lec.spring.service;

import com.lec.spring.domain.Transactions;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionsService {
    List<Transactions> findByMonth(Long userId, Integer year, int month);
    List<Transactions> findByDay(Long userId, LocalDate date);
    List<Transactions> findFixedExpenses(Long userId);
    List<Transactions> findByUserId(Long id);
    int save(Transactions transactions);
    int update(Transactions transactions);
    Transactions findById(Long id);
    int delete(Long id);
}
