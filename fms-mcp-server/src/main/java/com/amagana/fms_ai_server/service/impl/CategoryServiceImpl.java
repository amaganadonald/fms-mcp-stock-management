package com.amagana.fms_ai_server.service.impl;

import com.amagana.fms_ai_server.domain.Category;
import com.amagana.fms_ai_server.dto.CategoryRequestDTO;
import com.amagana.fms_ai_server.dto.CategoryResponseDTO;
import com.amagana.fms_ai_server.exceptions.EntityNotFoundException;
import com.amagana.fms_ai_server.mappers.CategoryMapper;
import com.amagana.fms_ai_server.repositoty.CategoryRepository;
import com.amagana.fms_ai_server.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        return categoryMapper.toCustomerDTO(categoryRepository.getReferenceById(id));
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        return categoryRepository.findAll().stream().map(categoryMapper::toCustomerDTO).toList();
    }

    @Override
    public CategoryResponseDTO getCategoryByCode(String code) {
        return categoryRepository.findByCode(code).map(categoryMapper::toCustomerDTO).orElse(null);
    }

    @Override
    public CategoryResponseDTO addCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toCustomer(categoryRequestDTO);
        return categoryMapper.toCustomerDTO(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        Optional<Category> category2 = categoryRepository.findById(id);
        if (category2.isPresent()) {
            return categoryMapper.toCustomerDTO(categoryRepository.save(Category.builder()
                    .libelle(categoryRequestDTO.libelle())
                    .description(categoryRequestDTO.description())
                    .build()));
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Category not found with id:  " +  id);
        }
    }
}
