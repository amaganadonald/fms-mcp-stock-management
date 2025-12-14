package com.amagana.fms_ai_server.mappers;

import com.amagana.fms_ai_server.domain.Customers;
import com.amagana.fms_ai_server.dto.CustomerRequestDTO;
import com.amagana.fms_ai_server.dto.CustomerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping(target = "id", ignore = true)
    Customers toCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO toCustomerDTO(Customers customers);
}
