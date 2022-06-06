package com.expensetracker.main.domain.expense.service;

import java.math.BigDecimal;
import java.util.List;

import com.expensetracker.main.domain.expense.dto.TotalExpenseAmountDto;
import com.expensetracker.main.domain.expense.entity.ExpenseEntity;
import com.expensetracker.main.domain.expense.repository.ExpenseRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Override
    public TotalExpenseAmountDto getTotalExpenseAmount() {
        BigDecimal totalAmount = new BigDecimal(0);

        List<ExpenseEntity> expenses = expenseRepository.findAll();

        for (ExpenseEntity expense : expenses) {
            totalAmount = totalAmount.add(expense.getAmount());
        }

        TotalExpenseAmountDto totalExpenseAmountDto = new TotalExpenseAmountDto(totalAmount);
        return totalExpenseAmountDto;
    }

    @Override
    public TotalExpenseAmountDto getTotalExpenseAmount(Long expenseGroupId) {
        BigDecimal totalAmount = new BigDecimal(0);

        List<ExpenseEntity> expenses = expenseRepository.findByExpenseGroupId(expenseGroupId);

        for (ExpenseEntity expense : expenses) {
            totalAmount = totalAmount.add(expense.getAmount());
        }

        TotalExpenseAmountDto totalExpenseAmountDto = new TotalExpenseAmountDto(totalAmount, expenseGroupId);

        return totalExpenseAmountDto;
    }

    @Override
    public List<ExpenseEntity> getLast5ExpenseChanges() {
        return expenseRepository.findFirst5ByOrderByUpdatedAtDesc();
    }

}
