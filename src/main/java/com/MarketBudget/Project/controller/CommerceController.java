package com.MarketBudget.Project.controller;

import com.MarketBudget.Project.dto.CommerceDTO;
import com.MarketBudget.Project.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
    @Autowired
    private CommerceService commerceService;

    @PostMapping
    public ResponseEntity<CommerceDTO> save(@RequestBody CommerceDTO commerceDTO){
        CommerceDTO commerceSaved = commerceService.save(commerceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(commerceSaved);
    }

    @GetMapping
    public ResponseEntity<List<CommerceDTO>> getAll() {
        List<CommerceDTO> commerce = commerceService.getAllCommerce();
        return ResponseEntity.ok().body(commerce);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommerceDTO update(@PathVariable Long id, @RequestBody CommerceDTO commerceDTO){
        return commerceService.update(id, commerceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.commerceService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
