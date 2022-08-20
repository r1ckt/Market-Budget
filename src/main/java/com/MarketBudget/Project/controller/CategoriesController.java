package com.MarketBudget.Project.controller;

import com.MarketBudget.Project.dto.CategoriesDTO;
import com.MarketBudget.Project.dto.CustomerDTO;
import com.MarketBudget.Project.service.CategoriesService;
import com.MarketBudget.Project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public ResponseEntity<CategoriesDTO> save(@RequestBody CategoriesDTO categoriesDTO){
        CategoriesDTO customerSaved = categoriesService.save(categoriesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerSaved);
    }

    @GetMapping
    public ResponseEntity<List<CategoriesDTO>> getAll() {
        List<CategoriesDTO> categories = categoriesService.getAllCategories();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoriesDTO update(@PathVariable Long id, @RequestBody CategoriesDTO customerDTO){
        return categoriesService.update(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.categoriesService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
