package com.amagana.fms_ai_server.service;

import com.amagana.fms_ai_server.dto.CustomerRequestDTO;
import com.amagana.fms_ai_server.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO getCustomersById(Long id);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerByCode(String code);
    CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(Long id);
}
