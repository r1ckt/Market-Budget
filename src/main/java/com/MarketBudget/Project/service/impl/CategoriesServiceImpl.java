package com.MarketBudget.Project.service.impl;

import com.MarketBudget.Project.dto.CategoriesDTO;
import com.MarketBudget.Project.entity.Categories;
import com.MarketBudget.Project.exception.ParamNotFoundException;
import com.MarketBudget.Project.mapper.CategoriesMapper;
import com.MarketBudget.Project.repository.CategoriesRepository;
import com.MarketBudget.Project.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    private CategoriesMapper categoriesMapper;
    private CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesMapper categoriesMapper, CategoriesRepository categoriesRepository) {
        this.categoriesMapper = categoriesMapper;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public CategoriesDTO save(CategoriesDTO categoriesDTO) {

        Categories entity = categoriesMapper.categoriesDTO2Entity(categoriesDTO);
        Categories entitySaved = categoriesRepository.save(entity);

        return categoriesMapper.categoriesEntity2DTO(entitySaved);
    }

    @Override
    public List<CategoriesDTO> getAllCategories() {

        List<Categories> entities = categoriesRepository.findAll();

        return categoriesMapper.categoriesEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        this.categoriesRepository.deleteById(id);
    }

    @Override
    public CategoriesDTO update(Long id, CategoriesDTO categoriesDTO) {

        Optional<Categories> entity = categoriesRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ParamNotFoundException("Error: Invalid character id");
        }

        categoriesMapper.categoriesEntityRefreshValues(entity.get(), categoriesDTO);

        Categories entitySaved = categoriesRepository.save(entity.get());

        return categoriesMapper.categoriesEntity2DTO(entitySaved);
    }
}
