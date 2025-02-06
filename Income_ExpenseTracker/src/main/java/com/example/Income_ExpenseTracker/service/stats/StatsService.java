package com.example.Income_ExpenseTracker.service.stats;

import com.example.Income_ExpenseTracker.DTO.GraphDTO;
import com.example.Income_ExpenseTracker.DTO.StatsDTO;
import org.springframework.stereotype.Service;

@Service
public interface StatsService {
    public GraphDTO getChartdata();
    public StatsDTO getStats();
}
