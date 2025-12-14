package com.amagana.fms_ai_server.mcp.adapters;

import com.amagana.fms_ai_server.annotations.McpToolService;
import com.amagana.fms_ai_server.dto.CategoryRequestDTO;
import com.amagana.fms_ai_server.dto.CategoryResponseDTO;
import com.amagana.fms_ai_server.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;

import java.util.List;

@McpToolService
public class CategoryMcpAdapter {

    private static final Logger log = LoggerFactory.getLogger(CategoryMcpAdapter.class);
    private final CategoryService categoryService;

    public CategoryMcpAdapter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Tool(description = "Get category by given id")
    public CategoryResponseDTO getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    @Tool(description = "Get List of All category")
    public List<CategoryResponseDTO> getAllCategory() {
        log.info("Retrieves all categories");
        return categoryService.getAllCategory();
    }

    @Tool(description = "Get Category Product by Code")
    public CategoryResponseDTO getCategoryByCode(String code) {
        return categoryService.getCategoryByCode(code);
    }

    @Tool(description = "Add Category to database")
    public CategoryResponseDTO addCategory(CategoryRequestDTO categoryRequestDTO) {
        return categoryService.addCategory(categoryRequestDTO);
    }

    @Tool(description = "Update category by given id and updated category info")
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        return categoryService.updateCategory(id, categoryRequestDTO);
    }

    @Tool(description = "Delete category by given id only if category exists")
    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }
}
