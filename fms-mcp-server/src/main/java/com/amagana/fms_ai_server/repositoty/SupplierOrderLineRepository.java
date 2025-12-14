package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.SupplierOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine, Long> {
}
