package com.MarketBudget.Project.service.impl;

import com.MarketBudget.Project.dto.BudgetDTO;
import com.MarketBudget.Project.entity.Budget;
import com.MarketBudget.Project.exception.ParamNotFoundException;
import com.MarketBudget.Project.mapper.BudgetMapper;
import com.MarketBudget.Project.repository.BudgetRepository;
import com.MarketBudget.Project.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    private BudgetMapper budgetMapper;
    private BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(BudgetMapper budgetMapper, BudgetRepository budgetRepository) {
        this.budgetMapper = budgetMapper;
        this.budgetRepository = budgetRepository;
    }


    @Override
    public BudgetDTO save(BudgetDTO budgetDTO) {

        Budget entity = budgetMapper.budgetDTO2Entity(budgetDTO);
        Budget entitySaved = budgetRepository.save(entity);

        return budgetMapper.budgetEntity2DTO(entitySaved);
    }

    @Override
    public List<BudgetDTO> getAllBudget() {

        List<Budget> entities = budgetRepository.findAll();

        return budgetMapper.budgetEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        this.budgetRepository.deleteById(id);
    }

    @Override
    public BudgetDTO update(Long id, BudgetDTO budgetDTO) {

        Optional<Budget> entity = budgetRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ParamNotFoundException("Error: Invalid character id");
        }

        budgetMapper.budgetEntityRefreshValues(entity.get(), budgetDTO);

        Budget entitySaved = budgetRepository.save(entity.get());

        return budgetMapper.budgetEntity2DTO(entitySaved);
    }
}
