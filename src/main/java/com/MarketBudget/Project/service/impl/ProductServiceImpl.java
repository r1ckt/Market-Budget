package com.MarketBudget.Project.service.impl;

import com.MarketBudget.Project.dto.CustomerDTO;
import com.MarketBudget.Project.dto.ProductDTO;
import com.MarketBudget.Project.entity.Product;
import com.MarketBudget.Project.entity.user.Customer;
import com.MarketBudget.Project.exception.ParamNotFoundException;
import com.MarketBudget.Project.mapper.CustomerMapper;
import com.MarketBudget.Project.mapper.ProductMapper;
import com.MarketBudget.Project.repository.CustomerRepository;
import com.MarketBudget.Project.repository.ProductRepository;
import com.MarketBudget.Project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO save(ProductDTO customerDTO) {

        Product entity = productMapper.productDTO2Entity(customerDTO);
        Product entitySaved = productRepository.save(entity);

        return productMapper.productEntity2DTO(entitySaved);
    }

    @Override
    public List<ProductDTO> getAllProduct() {

        List<Product> entities = productRepository.findAll();

        return productMapper.productEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public ProductDTO update(Long id, ProductDTO genreDTO) {

        Optional<Product> entity = productRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ParamNotFoundException("Error: Invalid character id");
        }

        productMapper.productEntityRefreshValues(entity.get(), genreDTO);

        Product entitySaved = productRepository.save(entity.get());

        return productMapper.productEntity2DTO(entitySaved);
    }
}
