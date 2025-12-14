package com.amagana.fms_ai_server.dto;

import com.amagana.fms_ai_server.domain.Category;
import com.amagana.fms_ai_server.enums.Units;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String name, String reference, String description, BigDecimal purchase_price,
                                 BigDecimal selling_price, Units unit, boolean active, String category) {
}
