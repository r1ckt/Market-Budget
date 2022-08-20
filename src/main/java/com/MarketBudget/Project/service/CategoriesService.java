package com.MarketBudget.Project.service;


import com.MarketBudget.Project.dto.CategoriesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {
    CategoriesDTO save(CategoriesDTO categoriesDTO);
    List<CategoriesDTO> getAllCategories();
    void delete(Long id);
    CategoriesDTO update(Long id, CategoriesDTO categoriesDTO);
}
