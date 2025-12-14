package com.amagana.fms_ai_server.service.impl;

import com.amagana.fms_ai_server.domain.Suppliers;
import com.amagana.fms_ai_server.dto.SupplierRequestDTO;
import com.amagana.fms_ai_server.dto.SupplierResponseDTO;
import com.amagana.fms_ai_server.exceptions.EntityNotFoundException;
import com.amagana.fms_ai_server.mappers.SupplierMapper;
import com.amagana.fms_ai_server.repositoty.SupplierRepository;
import com.amagana.fms_ai_server.service.SupplierService;
import jakarta.transaction.Transactional;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository providersRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = providersRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    @Tool(description = "Get Supplier by id")
    public SupplierResponseDTO getSupplierById(Long id) {
        return supplierMapper.toSupplierDTO(supplierRepository.getReferenceById(id));
    }

    @Override
    @Tool(description = "Get List of all Suppliers")
    public List<SupplierResponseDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(supplierMapper::toSupplierDTO).toList();
    }

    @Override
    @Tool(description = "Get Supplier by given code")
    public SupplierResponseDTO getSupplierByCode(String code) {
        return supplierRepository.findByCode(code).map(supplierMapper::toSupplierDTO).orElse(null);
    }

    @Override
    @Tool(description = "Add Supplier inside database")
    public SupplierResponseDTO addSupplier(SupplierRequestDTO supplierRequestDTO) {
        Suppliers supplier = supplierMapper.toSupplier(supplierRequestDTO);
        return supplierMapper.toSupplierDTO(supplierRepository.save(supplier));
    }

    @Override
    @Tool(description = "Update Supplier with given id and updated supplier information's")
    public SupplierResponseDTO updateSupplier(Long id, SupplierRequestDTO supplierRequestDTO) {
        Optional<Suppliers> provider = supplierRepository.findById(id);
        if(provider.isPresent()) {
            return supplierMapper.toSupplierDTO(supplierRepository.save(Suppliers.builder()
                    .code(supplierRequestDTO.code())
                    .active(supplierRequestDTO.active())
                    .name(supplierRequestDTO.name())
                    .address(supplierRequestDTO.address())
                    .email(supplierRequestDTO.email())
                    .phone(supplierRequestDTO.phone())
                    .build()));
        }
        return null;
    }

    @Override
    @Tool(description = "Delete Provider by given id if exist")
    public void deleteSupplier(Long id) {
        Optional<Suppliers> provider = supplierRepository.findById(id);
        if (provider.isPresent()) {
            supplierRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Provider not found with id: " + id);
        }
    }
}
