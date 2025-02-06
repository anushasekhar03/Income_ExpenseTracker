package com.example.Income_ExpenseTracker.controller;

import com.example.Income_ExpenseTracker.DTO.ExpenseDTO;
import com.example.Income_ExpenseTracker.Entity.Expense;
import com.example.Income_ExpenseTracker.service.ExpenseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
public class expenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public ResponseEntity<?>postExpense(@RequestBody ExpenseDTO dto){
        Expense createdExpense=service.addExpense(dto);
        if(createdExpense!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?>getAllExoense(){
        return ResponseEntity.ok(service.getAllExpenses());
    }

    @GetMapping("/{id}")
  public ResponseEntity<?>getExpenseById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.getExpenseById(id));
        }
        catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
      }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?>updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO dto){
        try{
            return ResponseEntity.ok(service.updateExpense(id,dto));
        }catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
  }

  @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteExpense(@PathVariable Long id){
        try{
           service.deleteExpense(id);
           return ResponseEntity.ok(null);
        }catch(EntityNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }


}
