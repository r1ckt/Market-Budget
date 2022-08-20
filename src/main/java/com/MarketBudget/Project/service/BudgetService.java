package com.MarketBudget.Project.service;

import com.MarketBudget.Project.dto.BudgetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BudgetService {
    BudgetDTO save(BudgetDTO budgetDTO);
    List<BudgetDTO> getAllBudget();
    void delete(Long id);
    BudgetDTO update(Long id, BudgetDTO budgetDTO);
}
