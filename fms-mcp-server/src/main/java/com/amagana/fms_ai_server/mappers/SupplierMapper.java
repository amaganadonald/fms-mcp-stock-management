package com.amagana.fms_ai_server.mappers;

import com.amagana.fms_ai_server.domain.Suppliers;
import com.amagana.fms_ai_server.dto.SupplierRequestDTO;
import com.amagana.fms_ai_server.dto.SupplierResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
    @Mapping(target = "id", ignore = true)
    Suppliers toSupplier(SupplierRequestDTO supplierRequestDTO);
    SupplierResponseDTO toSupplierDTO(Suppliers suppliers);
}
