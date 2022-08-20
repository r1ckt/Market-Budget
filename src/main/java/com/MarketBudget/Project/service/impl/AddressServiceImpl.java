package com.MarketBudget.Project.service.impl;

import com.MarketBudget.Project.dto.AddressDTO;
import com.MarketBudget.Project.entity.user.Address;
import com.MarketBudget.Project.exception.ParamNotFoundException;
import com.MarketBudget.Project.mapper.AddressMapper;
import com.MarketBudget.Project.repository.AddressRepository;
import com.MarketBudget.Project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {
    private AddressMapper addressMapper;
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {

        Address entity = addressMapper.addressDTO2Entity(addressDTO);
        Address  entitySaved = addressRepository.save(entity);

        return addressMapper.addressEntity2DTO(entitySaved);
    }

    @Override
    public List<AddressDTO> getAllAddress() {

        List<Address> entities = addressRepository.findAll();

        return addressMapper.addressEntityList2DTOList(entities);
    }

    @Override
    public void delete(Long id) {
        this.addressRepository.deleteById(id);
    }

    @Override
    public AddressDTO update(Long id, AddressDTO addressDTO){

        Optional<Address> entity = addressRepository.findById(id);

        if (entity.isEmpty()) {
            throw new ParamNotFoundException("Error: Invalid character id");
        }

        addressMapper.addressEntityRefreshValues(entity.get(), addressDTO);

        Address entitySaved = addressRepository.save(entity.get());

        return addressMapper.addressEntity2DTO(entitySaved);
    }
}
