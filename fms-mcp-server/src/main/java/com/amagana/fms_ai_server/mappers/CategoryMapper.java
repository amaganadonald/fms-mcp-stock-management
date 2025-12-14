package com.amagana.fms_ai_server.mappers;

import com.amagana.fms_ai_server.domain.Category;
import com.amagana.fms_ai_server.dto.CategoryRequestDTO;
import com.amagana.fms_ai_server.dto.CategoryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    @Mapping(target = "id", ignore = true)
    Category toCustomer(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO toCustomerDTO(Category category);
}
