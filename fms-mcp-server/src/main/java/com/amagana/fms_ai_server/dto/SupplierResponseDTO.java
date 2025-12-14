package com.amagana.fms_ai_server.dto;

import com.amagana.fms_ai_server.domain.SupplierOrder;
import java.util.List;

public record SupplierResponseDTO(Long id,String code,String name,String phone,String email,
        String address,boolean active,List<SupplierOrder> supplierOrders) {
}
