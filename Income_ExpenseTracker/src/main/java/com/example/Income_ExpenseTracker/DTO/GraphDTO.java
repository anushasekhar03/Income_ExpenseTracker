package com.example.Income_ExpenseTracker.DTO;

import com.example.Income_ExpenseTracker.Entity.Expense;
import com.example.Income_ExpenseTracker.Entity.Income;

import java.util.List;

public class GraphDTO {
    private List<Expense>expensesList;

    private List<Income>incomeList;

    public List<Expense> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expense> expensesList) {
        this.expensesList = expensesList;
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(List<Income> incomeList) {
        this.incomeList = incomeList;
    }


}
