package com.amagana.fms_ai_server.service;

import com.amagana.fms_ai_server.dto.ProductRequestDTO;
import com.amagana.fms_ai_server.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO getProductByReference(String reference);
    Page<ProductResponseDTO> getProductsByPage(int size, int page);
    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    void deleteProduct(Long id);
}
