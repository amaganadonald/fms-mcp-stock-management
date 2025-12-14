package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.CustomerOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Long> {
}
