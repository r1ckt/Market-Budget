package com.MarketBudget.Project.service;

import com.MarketBudget.Project.dto.AddressDTO;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface AddressService {
    AddressDTO save(AddressDTO addressDTO);
    List<AddressDTO> getAllAddress();
    void delete(Long id);
    AddressDTO update(Long id, AddressDTO addressDTO);
}
