package com.example.Income_ExpenseTracker.controller;

import com.example.Income_ExpenseTracker.DTO.IncomeDTO;
import com.example.Income_ExpenseTracker.Entity.Income;
import com.example.Income_ExpenseTracker.service.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/income")
public class incomeController {

    @Autowired
    private IncomeService service;

    @PostMapping
    public ResponseEntity<?>postIncome(@RequestBody IncomeDTO incomeDto){
        Income createdIncome=service.postIncome(incomeDto);
        if(createdIncome!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?>getAllIncome(){
        return ResponseEntity.ok(service.getAllIncomes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        try {
            Income updatedIncome = service.updateIncome(id, incomeDTO); // Correctly passing the incoming DTO
            return ResponseEntity.ok(updatedIncome);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/{id}")
 public ResponseEntity<?>getIncomebyId(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.getIncomeById(id));
        }catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
     }
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?>deletebyId(@PathVariable Long id){
     try{
         service.deleteIncome(id);
         return ResponseEntity.ok(null);
     }catch (EntityNotFoundException ex) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
     } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
     }
 }

}
