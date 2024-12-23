package com.lec.spring.repository;

import com.lec.spring.domain.Transactions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TransactionsRepository {

    // 달 통계
    List<Transactions> findByMonth(@Param("userId") Long userId, Integer year, int month);

    // 일마다 지출, 수입
    List<Transactions> findByDay(@Param("userId") Long userId, LocalDate date);
    List<Transactions> findFixedExpenses(@Param("userId") Long userId);

    List<Transactions> findByUserId(Long id);

    int save(Transactions transactions);
    int update(Transactions transactions);

    Transactions findById(Long id);
    int delete(Long id);

}
