package com.MarketBudget.Project.service;


import com.MarketBudget.Project.dto.ProductDTO;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    List<ProductDTO> getAllProduct();
    void delete(Long id);
    ProductDTO update(Long id, ProductDTO productDTO);
}
