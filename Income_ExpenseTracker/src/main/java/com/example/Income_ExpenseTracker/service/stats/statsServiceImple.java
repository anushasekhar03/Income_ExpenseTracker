package com.example.Income_ExpenseTracker.service.stats;

import com.example.Income_ExpenseTracker.DTO.GraphDTO;
import com.example.Income_ExpenseTracker.DTO.StatsDTO;
import com.example.Income_ExpenseTracker.Entity.Expense;
import com.example.Income_ExpenseTracker.Entity.Income;
import com.example.Income_ExpenseTracker.repository.ExpenseRepo;
import com.example.Income_ExpenseTracker.repository.incomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class statsServiceImple implements StatsService{

    @Autowired
    private incomeRepo Irepo;

    @Autowired
    private ExpenseRepo Erepo;

    public GraphDTO getChartdata() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(2);  // Get data from last 2 months
        // Adjusted to get last 28 days

        // Debugging output to check the date range
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpensesList(Erepo.findByDateBetween(startDate, endDate));  // Fetch expenses for the date range
        graphDTO.setIncomeList(Irepo.findByDateBetween(startDate, endDate));     // Fetch incomes for the date range

        // Debug logs to verify the list size
        System.out.println("Expenses List Size: " + graphDTO.getExpensesList().size());
        System.out.println("Income List Size: " + graphDTO.getIncomeList().size());

        return graphDTO;
    }

    public StatsDTO getStats(){
        Double totalIncome= Irepo.sumAllAmounts();
        Double totalExpense= Erepo.sumAllAmounts();

        Optional<Income> optionalIncome=Irepo.findFirstByOrderByDate();
        Optional<Expense>optionalExpense= Erepo.findFirstByOrderByDate();


        StatsDTO statsDTO=new StatsDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);

       optionalIncome.ifPresent(statsDTO::setLatestIncome);
       optionalExpense.ifPresent(statsDTO::setLatestExpense);

       statsDTO.setBalance(totalIncome-totalExpense);
        List<Income>incomelist=Irepo.findAll();
        List<Expense>expenseList= Erepo.findAll();

        OptionalDouble minIncome=incomelist.stream().mapToDouble(Income::getAmount).min();
        OptionalDouble maxIncome=incomelist.stream().mapToDouble(Income::getAmount).max();

        OptionalDouble minExpense=expenseList.stream().mapToDouble(Expense::getAmount).min();
        OptionalDouble maxExpense=expenseList.stream().mapToDouble(Expense::getAmount).max();

        statsDTO.setMaxExpense(maxExpense.isPresent() ? maxExpense.getAsDouble():null);
        statsDTO.setMinExpense(minExpense.isPresent() ? minExpense.getAsDouble():null);

        statsDTO.setMaxIncome(maxIncome.isPresent() ? maxIncome.getAsDouble():null);
        statsDTO.setMinIncome(minIncome.isPresent() ? minIncome.getAsDouble():null);

        return statsDTO;
    }

}
