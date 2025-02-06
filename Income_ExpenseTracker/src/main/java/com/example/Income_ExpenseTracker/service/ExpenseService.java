package com.example.Income_ExpenseTracker.service;

import com.example.Income_ExpenseTracker.DTO.ExpenseDTO;
import com.example.Income_ExpenseTracker.Entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {

    public Expense addExpense(ExpenseDTO expenseDTO);
    public List<Expense> getAllExpenses();
    public Expense getExpenseById(Long id);
    public Expense updateExpense(Long id,ExpenseDTO expenseDTO);
    public void deleteExpense(Long id);
}
