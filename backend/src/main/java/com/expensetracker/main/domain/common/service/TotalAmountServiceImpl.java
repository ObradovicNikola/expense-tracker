package com.expensetracker.main.domain.common.service;

import java.math.BigDecimal;
import java.util.List;

import com.expensetracker.main.domain.common.dto.TotalAmountDto;
import com.expensetracker.main.domain.expense.entity.ExpenseEntity;
import com.expensetracker.main.domain.expense.repository.ExpenseRepository;
import com.expensetracker.main.domain.income.entity.IncomeEntity;
import com.expensetracker.main.domain.income.repository.IncomeRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TotalAmountServiceImpl implements TotalAmountService {
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    @Override
    public TotalAmountDto getTotalAmount(Long userId) {
        BigDecimal totalExpenses = new BigDecimal(0);

        List<ExpenseEntity> expenses = expenseRepository.findByUserId(userId);

        for (ExpenseEntity expense : expenses) {
            totalExpenses = totalExpenses.add(expense.getAmount());
        }

        BigDecimal totalIncome = new BigDecimal(0);

        List<IncomeEntity> incomes = incomeRepository.findByUserId(userId);

        for (IncomeEntity income : incomes) {
            totalIncome = totalIncome.add(income.getAmount());
        }

        TotalAmountDto totalAmountDto = TotalAmountDto.builder()
                .totalAmount(totalIncome.subtract(totalExpenses))
                .totalExpenses(totalExpenses)
                .totalIncomes(totalIncome)
                .build();

        return totalAmountDto;
    }

}
