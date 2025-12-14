package com.amagana.fms_ai_server.repositoty;

import com.amagana.fms_ai_server.domain.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}
