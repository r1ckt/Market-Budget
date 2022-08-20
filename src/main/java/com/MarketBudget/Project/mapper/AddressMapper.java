package com.MarketBudget.Project.mapper;

import com.MarketBudget.Project.dto.AddressDTO;
import com.MarketBudget.Project.entity.user.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper {
    public Address addressDTO2Entity(AddressDTO dto) {

        Address entity = new Address();
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setZipCode(dto.getZipCode());
        return entity;
    }

    public AddressDTO addressEntity2DTO(Address entity) {

        AddressDTO dto = new AddressDTO();
        dto.setId(entity.getId());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setZipCode(entity.getZipCode());

        return dto;
    }

    public List<AddressDTO> addressEntityList2DTOList(List<Address > entities) {

        List<AddressDTO> dtos = new ArrayList<>();

        for (Address  entity : entities) {
            dtos.add(this.addressEntity2DTO(entity));
        }

        return dtos;
    }


    public void addressEntityRefreshValues(Address  entity, AddressDTO dto) {

        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setZipCode(dto.getZipCode());
    }
}
