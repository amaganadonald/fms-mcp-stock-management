package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Suppliers, Long> {

    Optional<Suppliers> findByCode(String code);
}
