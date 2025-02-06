package com.example.Income_ExpenseTracker.service;

import com.example.Income_ExpenseTracker.DTO.ExpenseDTO;
import com.example.Income_ExpenseTracker.DTO.IncomeDTO;
import com.example.Income_ExpenseTracker.Entity.Expense;
import com.example.Income_ExpenseTracker.Entity.Income;
import com.example.Income_ExpenseTracker.repository.incomeRepo;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImple implements IncomeService{

    @Autowired
    private incomeRepo repo;

    public Income postIncome(IncomeDTO incomeDTO){
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }


    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());  // Ensure this is set
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());
        return repo.save(income);
    }


    public List<IncomeDTO> getAllIncomes(){
        List<IncomeDTO> incomes = repo.findAll().stream()
                .sorted(Comparator.comparing(Income::getDate).reversed())
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());

        System.out.println("Fetched Incomes: " + incomes);
        return incomes;
    }

    public Income updateIncome(Long id, IncomeDTO incomeDTO){
        Optional<Income>optionalIncome=repo.findById(id);
        if(optionalIncome.isPresent()){
            return saveOrUpdateIncome(optionalIncome.get(),incomeDTO);
        }
        else{
            throw new EntityNotFoundException("Income is not present with id " + id);
        }
    }
    public IncomeDTO getIncomeById(Long id){
        Optional<Income>optionalincome=repo.findById(id);
        if(optionalincome.isPresent()){
            return optionalincome.get().getIncomeDto();
        }
        else{
            throw new EntityNotFoundException("Income is not present with id " + id);
        }
    }

    public void deleteIncome(Long id){
        Optional<Income>optionalincome=repo.findById(id);
        if(optionalincome.isPresent()){
            repo.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Income is not present with id " + id);
        }

    }

}
