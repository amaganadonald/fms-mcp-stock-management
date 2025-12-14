package com.amagana.fms_ai_server.mcp.adapters;

import com.amagana.fms_ai_server.annotations.McpToolService;
import com.amagana.fms_ai_server.dto.ProductRequestDTO;
import com.amagana.fms_ai_server.dto.ProductResponseDTO;
import com.amagana.fms_ai_server.service.ProductService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
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
    public Page<ProductResponseDTO> getProductsByPage(@ToolParam(description = "number of elements to retrieves") int size,
                                                      @ToolParam(description = "Page number") int page) {
        return productService.getProductsByPage(size, page);
    }

    @Tool(description = "Add product to database")
    public ProductResponseDTO addProduct(@ToolParam(description = "Products information to add to database") ProductRequestDTO productRequestDTO) {
        return productService.addProduct(productRequestDTO);
    }

    @Tool(description = "Update product by given id and updated Product data")
    public ProductResponseDTO updateProduct(@ToolParam(description = "Product id existing inside database") Long id,
                                            @ToolParam(description = "Products information to add to update") ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(id, productRequestDTO);
    }

    @Tool(description = "Delete Product by given id if exist")
    public void deleteProduct(@ToolParam(description = "Product id to delete inside database") Long id) {
        productService.deleteProduct(id);
    }

}
