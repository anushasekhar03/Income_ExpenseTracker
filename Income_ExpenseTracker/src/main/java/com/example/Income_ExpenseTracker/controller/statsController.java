package com.example.Income_ExpenseTracker.controller;


import com.example.Income_ExpenseTracker.DTO.GraphDTO;
import com.example.Income_ExpenseTracker.service.stats.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class statsController {

    @Autowired
    private StatsService service1;

    @GetMapping("/chart")
    public ResponseEntity<GraphDTO> getChartDetails() {
        GraphDTO graphDTO = service1.getChartdata();

        if (graphDTO.getExpensesList().isEmpty() && graphDTO.getIncomeList().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }

        return ResponseEntity.ok(graphDTO);
    }

    @GetMapping
    public ResponseEntity<?>getStats(){
        return ResponseEntity.ok(service1.getStats());
    }
}
