package com.expensetracker.main.domain.expense.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.expensetracker.main.domain.common.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "expense_groups")
public class ExpenseGroup extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "expenseGroup", cascade = CascadeType.ALL)
    private List<ExpenseEntity> expenses = new ArrayList<>();

    @Builder
    public ExpenseGroup(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
