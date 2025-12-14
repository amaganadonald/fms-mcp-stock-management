package com.amagana.fms_ai_server.service;

import com.amagana.fms_ai_server.domain.Category;
import com.amagana.fms_ai_server.dto.CategoryRequestDTO;
import com.amagana.fms_ai_server.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO getCategoryById(Long id);
    List<CategoryResponseDTO> getAllCategory();
    CategoryResponseDTO getCategoryByCode(String code);
    CategoryResponseDTO addCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO);
    void deleteCategory(Long id);
}
