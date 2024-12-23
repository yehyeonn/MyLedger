package com.lec.spring.service;

import com.lec.spring.domain.Transactions;
import com.lec.spring.domain.User;
import com.lec.spring.repository.TransactionsRepository;
import com.lec.spring.utill.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService{
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public List<Transactions> findByMonth(Long userId, Integer year, int month) {
        return transactionsRepository.findByMonth(userId, year, month);
    }

    @Override
    public List<Transactions> findByDay(Long userId, LocalDate date){
        return transactionsRepository.findByDay(userId, date);
    }

    @Override
    public List<Transactions> findFixedExpenses(Long userId){
        return transactionsRepository.findFixedExpenses(userId);
    }

    @Override
    public List<Transactions> findByUserId(Long id) {
        return transactionsRepository.findByUserId(id);
    }

    @Override
    public int save(Transactions transactions){
        User user = U.getLoggedUser();
        transactions.setUser_id(user.getId());
        int cnt = transactionsRepository.save(transactions);
        return cnt;
    }

    @Override
    public int update(Transactions transactions){
        return transactionsRepository.update(transactions);
    }

    @Override
    public Transactions findById(Long id) {
        Transactions transactions = transactionsRepository.findById(id);
        return transactions;
    }

    @Override
    public int delete(Long id) {
        int cnt = 0;
        Transactions transactions = transactionsRepository.findById(id);
        if(transactions != null) cnt = transactionsRepository.delete(id);
        return cnt;
    }
}
