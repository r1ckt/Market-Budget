package com.MarketBudget.Project.service.impl;

import com.MarketBudget.Project.dto.CommerceDTO;
import com.MarketBudget.Project.entity.user.Commerce;
import com.MarketBudget.Project.exception.ParamNotFoundException;
import com.MarketBudget.Project.mapper.CommerceMapper;
import com.MarketBudget.Project.repository.CommerceRepository;
import com.MarketBudget.Project.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommerceServiceImpl implements CommerceService {
    private CommerceMapper commerceMapper;
    private CommerceRepository commerceRepository;

    @Autowired
    public CommerceServiceImpl(CommerceMapper commerceMapper, CommerceRepository commerceRepository) {
        this.commerceMapper = commerceMapper;
        this.commerceRepository = commerceRepository;
    }

    @Override
    public CommerceDTO save(CommerceDTO commerceDTO) {

        Commerce entity = commerceMapper.commerceDTO2Entity(commerceDTO);
        Commerce entitySaved = commerceRepository.save(entity);

        return commerceMapper.commerceEntity2DTO(entitySaved);
    }

    @Override
    public List<CommerceDTO> getAllCommerce() {

        List<Commerce> entities = commerceRepository.findAll();

        return commerceMapper.commerceEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        this.commerceRepository.deleteById(id);
    }

    @Override
    public CommerceDTO update(Long id, CommerceDTO commerceDTO) {

        Optional<Commerce> entity = commerceRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ParamNotFoundException("Error: Invalid character id");
        }

        commerceMapper.commerceEntityRefreshValues(entity.get(), commerceDTO);

        Commerce entitySaved = commerceRepository.save(entity.get());

        return commerceMapper.commerceEntity2DTO(entitySaved);
    }
}
