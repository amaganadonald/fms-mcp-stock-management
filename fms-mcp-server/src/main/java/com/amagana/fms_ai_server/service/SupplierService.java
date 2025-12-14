package com.amagana.fms_ai_server.service;

import com.amagana.fms_ai_server.dto.SupplierRequestDTO;
import com.amagana.fms_ai_server.dto.SupplierResponseDTO;

import java.util.List;

public interface SupplierService {
    SupplierResponseDTO getSupplierById(Long id);
    List<SupplierResponseDTO> getAllSuppliers();
    SupplierResponseDTO getSupplierByCode(String code);
    SupplierResponseDTO addSupplier(SupplierRequestDTO supplierRequestDTO);
    SupplierResponseDTO updateSupplier(Long id, SupplierRequestDTO supplierRequestDTO);
    void deleteSupplier(Long id);
}
