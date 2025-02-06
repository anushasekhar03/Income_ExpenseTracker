package com.example.Income_ExpenseTracker.Entity;

import com.example.Income_ExpenseTracker.DTO.IncomeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Income {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer amount;
    private LocalDate date;
    private String category;
    private String description;
    public IncomeDTO getIncomeDto(){
        IncomeDTO incomeDTO=new IncomeDTO();
        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setCategory(category);
        incomeDTO.setDescription(description);
        incomeDTO.setDate(date);

        return incomeDTO;

    }

    public Income(Long id, String title, Integer amount, LocalDate date, String category, String description) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.description = description;
    }

    public Income() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
