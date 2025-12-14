package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
