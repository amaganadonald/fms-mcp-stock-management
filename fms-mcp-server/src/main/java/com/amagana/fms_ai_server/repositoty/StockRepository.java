package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
