package com.MarketBudget.Project.controller;

import com.MarketBudget.Project.dto.BudgetDTO;
import com.MarketBudget.Project.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public ResponseEntity<BudgetDTO> save(@RequestBody BudgetDTO budgetDTO){
        BudgetDTO budgetSaved = budgetService.save(budgetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(budgetSaved);
    }

    @GetMapping
    public ResponseEntity<List<BudgetDTO>> getAll() {
        List<BudgetDTO> budget = budgetService.getAllBudget();
        return ResponseEntity.ok().body(budget);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BudgetDTO update(@PathVariable Long id, @RequestBody BudgetDTO budgetDTO){
        return budgetService.update(id, budgetDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.budgetService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
