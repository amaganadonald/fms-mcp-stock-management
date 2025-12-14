package com.amagana.fms_ai_server.mcp.adapters;

import com.amagana.fms_ai_server.annotations.McpToolService;
import com.amagana.fms_ai_server.dto.ProductRequestDTO;
import com.amagana.fms_ai_server.dto.ProductResponseDTO;
import com.amagana.fms_ai_server.service.ProductService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.data.domain.Page;


@McpToolService
public class ProductMcpAdapter {

    private final ProductService productService;

    public ProductMcpAdapter(ProductService productService) {
        this.productService = productService;
    }

    @Tool(description = "Retrieves Product by id from the inventory database. Returns product with his details")
    public ProductResponseDTO getProductById(Long id) {
        return productService.getProductById(id);
    }


    @Tool(description = "Get Product by reference")
    public ProductResponseDTO getProductByReference(String reference) {
        return  productService.getProductByReference(reference);
    }

    @Tool(description = "Get Product by size of elements and page number")
    public Page<ProductResponseDTO> getProductsByPage(int size, int page) {
        return productService.getProductsByPage(size, page);
    }

    @Tool(description = "Add product to database")
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        return productService.addProduct(productRequestDTO);
    }

    @Tool(description = "Update product by given id and updated Product data")
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(id, productRequestDTO);
    }

    @Tool(description = "Delete Product by given id if exist")
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }

}
