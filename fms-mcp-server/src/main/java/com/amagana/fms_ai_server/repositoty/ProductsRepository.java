package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {

    Optional<Products> findByReference(String reference);
}
