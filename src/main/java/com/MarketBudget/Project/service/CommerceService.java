package com.MarketBudget.Project.service;


import com.MarketBudget.Project.dto.CommerceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommerceService {
    CommerceDTO save(CommerceDTO commerceDTO);
    List<CommerceDTO> getAllCommerce();
    void delete(Long id);
    CommerceDTO update(Long id, CommerceDTO commerceDTO);
}
