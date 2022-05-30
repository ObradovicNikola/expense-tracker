package com.expensetracker.main.domain.expense.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.expensetracker.main.domain.common.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "expenses")
public class ExpenseEntity extends BaseEntity {
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "expense_group_id")
    private ExpenseGroup expenseGroup;

    @Builder
    public ExpenseEntity(Long id, String description, Double amount, ExpenseGroup expenseGroup) {
        super(id);
        this.description = description;
        this.amount = amount;
        this.expenseGroup = expenseGroup;
    }
}
