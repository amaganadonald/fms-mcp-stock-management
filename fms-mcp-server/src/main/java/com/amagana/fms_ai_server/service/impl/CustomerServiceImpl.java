package com.amagana.fms_ai_server.service.impl;

import com.amagana.fms_ai_server.domain.Customers;
import com.amagana.fms_ai_server.dto.CustomerRequestDTO;
import com.amagana.fms_ai_server.dto.CustomerResponseDTO;
import com.amagana.fms_ai_server.exceptions.EntityNotFoundException;
import com.amagana.fms_ai_server.mappers.CustomerMapper;
import com.amagana.fms_ai_server.repositoty.CustomersRepository;
import com.amagana.fms_ai_server.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomersRepository customersRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomersRepository customersRepository, CustomerMapper customerMapper) {
        this.customersRepository = customersRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    @Tool(description = "Get Customer by Id")
    public CustomerResponseDTO getCustomersById(Long id) {
        return customerMapper.toCustomerDTO(customersRepository.getReferenceById(id));
    }

    @Override
    @Tool(description = "Get List of all Customer")
    public List<CustomerResponseDTO> getAllCustomers() {
        return customersRepository.findAll().stream().map(customerMapper::toCustomerDTO).toList();
    }

    @Override
    @Tool(description = "Get Customer By Code")
    public CustomerResponseDTO getCustomerByCode(String code) {
        return customersRepository.findByCode(code).map(customerMapper::toCustomerDTO).orElse(null);
    }

    @Override
    @Tool(description = "add Customer to database")
    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO) {
        Customers customer = customerMapper.toCustomer(customerRequestDTO);
        return customerMapper.toCustomerDTO(customersRepository.save(customer));
    }

    @Override
    @Tool(description = "Update customer if exist with updated customer info")
    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) {
        Optional<Customers> customers1 = customersRepository.findById(id);
        if(customers1.isPresent()) {
            return customerMapper.toCustomerDTO(customersRepository.save(Customers.builder()
                    .mail(customerRequestDTO.mail())
                    .code(customerRequestDTO.code())
                    .nom(customerRequestDTO.nom())
                    .phone(customerRequestDTO.phone())
                    .address(customerRequestDTO.address())
                    .build()));
        }
        return null;
    }

    @Override
    @Tool(description = "Delete customer if exist inside database")
    public void deleteCustomer(Long id) {
        Optional<Customers> customers = customersRepository.findById(id);
        if (customers.isPresent()) {
            customersRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Customer not found with id "+ id);
        }
    }
}
