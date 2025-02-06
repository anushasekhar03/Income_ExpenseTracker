package com.example.Income_ExpenseTracker.service;

import com.example.Income_ExpenseTracker.DTO.IncomeDTO;
import com.example.Income_ExpenseTracker.Entity.Income;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncomeService{
    public Income postIncome(IncomeDTO incomeDTO);
    public List<IncomeDTO> getAllIncomes();
    public Income updateIncome(Long id, IncomeDTO incomeDTO);
    public IncomeDTO getIncomeById(Long id);
    public void deleteIncome(Long id);
}
