package com.amagana.fms_ai_server.mappers;

import com.amagana.fms_ai_server.domain.Products;
import com.amagana.fms_ai_server.dto.ProductRequestDTO;
import com.amagana.fms_ai_server.dto.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Products toProduct(ProductRequestDTO productRequestDTO);

    @Mapping(target = "category", source = "category.libelle")
    ProductResponseDTO toProductDTO(Products products);
}
