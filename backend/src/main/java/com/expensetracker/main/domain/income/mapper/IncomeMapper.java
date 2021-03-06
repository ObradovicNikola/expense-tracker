package com.expensetracker.main.domain.income.mapper;

import org.springframework.stereotype.Component;

import com.expensetracker.main.domain.income.dto.IncomeGroupResponseDto;
import com.expensetracker.main.domain.income.dto.IncomeResponseDto;
import com.expensetracker.main.domain.income.entity.IncomeEntity;
import com.expensetracker.main.domain.income.entity.IncomeGroup;

@Component
public class IncomeMapper {
    public IncomeResponseDto toIncomeResponseDto(IncomeEntity income) {
        IncomeResponseDto incomeResponseDto = IncomeResponseDto.builder()
                .id(income.getId())
                .createdAt(income.getCreatedAt())
                .updatedAt(income.getUpdatedAt())
                .description(income.getDescription())
                .amount(income.getAmount())
                .build();

        if (income.getIncomeGroup() != null) {
            incomeResponseDto.setIncomeGroupId(income.getIncomeGroup().getId());
        }

        return incomeResponseDto;
    }

    public IncomeGroupResponseDto toIncomeGroupResponseDto(IncomeGroup incomeGroup) {
        return IncomeGroupResponseDto.builder()
                .id(incomeGroup.getId())
                .createdAt(incomeGroup.getCreatedAt())
                .updatedAt(incomeGroup.getUpdatedAt())
                .name(incomeGroup.getName())
                .description(incomeGroup.getDescription())
                .build();
    }
}
