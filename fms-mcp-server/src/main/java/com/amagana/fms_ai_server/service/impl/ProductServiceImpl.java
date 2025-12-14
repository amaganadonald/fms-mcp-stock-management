package com.amagana.fms_ai_server.service.impl;

import com.amagana.fms_ai_server.domain.Category;
import com.amagana.fms_ai_server.domain.Products;
import com.amagana.fms_ai_server.dto.ProductRequestDTO;
import com.amagana.fms_ai_server.dto.ProductResponseDTO;
import com.amagana.fms_ai_server.exceptions.EntityNotFoundException;
import com.amagana.fms_ai_server.mappers.ProductMapper;
import com.amagana.fms_ai_server.repositoty.CategoryRepository;
import com.amagana.fms_ai_server.repositoty.ProductsRepository;
import com.amagana.fms_ai_server.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductsRepository productsRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productsRepository = productsRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return productMapper.toProductDTO(productsRepository.getReferenceById(id));
    }

    @Override
    public ProductResponseDTO getProductByReference(String reference) {
        return  productsRepository.findByReference(reference).map(productMapper::toProductDTO)
                .orElse(null);
    }

    @Override
    public Page<ProductResponseDTO> getProductsByPage(int size, int page) {
        return productsRepository.findAll(PageRequest.of(size, page))
                .map(productMapper::toProductDTO);
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.getReferenceById(productRequestDTO.category());
        Products products = productMapper.toProduct(productRequestDTO);
        products.setCategory(category);
        return productMapper.toProductDTO(productsRepository.save(products));
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            Category category = categoryRepository.getReferenceById(productRequestDTO.category());
            return productMapper.toProductDTO(
                    productsRepository.save(Products.builder()
                            .purchase_price(productRequestDTO.purchase_price())
                            .description(productRequestDTO.description())
                            .category(category)
                            .reference(productRequestDTO.reference())
                            .selling_price(productRequestDTO.selling_price())
                            .build())
            );
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Products> product = productsRepository.findById(id);
        if (product.isPresent()) {
            productsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product not found with id : " + id);
        }
    }
}
