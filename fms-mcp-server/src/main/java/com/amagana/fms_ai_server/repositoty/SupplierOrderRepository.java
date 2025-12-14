package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.SupplierOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Long> {
}
