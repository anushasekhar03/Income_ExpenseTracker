package com.example.Income_ExpenseTracker.service;

import com.example.Income_ExpenseTracker.DTO.ExpenseDTO;
import com.example.Income_ExpenseTracker.Entity.Expense;
import com.example.Income_ExpenseTracker.repository.ExpenseRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImple implements ExpenseService {

    @Autowired
    private ExpenseRepo repo;

    public Expense addExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        return saveOrUpdateExpense(expense, expenseDTO);
    }


    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());
        return repo.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repo.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed())
                .collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id){
        Optional<Expense> optionalExpense=repo.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        }
        else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public Expense updateExpense(Long id,ExpenseDTO expenseDTO){
        Optional<Expense>optionalExpense=repo.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdateExpense(optionalExpense.get(),expenseDTO);
        }
        else{
            throw new EntityNotFoundException("Expense is not present with id " + id);
        }
    }

    public void deleteExpense(Long id){
        Optional<Expense>optionalExpense=repo.findById(id);
        if(optionalExpense.isPresent()){
            repo.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Expense is not present with id "+id);
        }
    }
}
