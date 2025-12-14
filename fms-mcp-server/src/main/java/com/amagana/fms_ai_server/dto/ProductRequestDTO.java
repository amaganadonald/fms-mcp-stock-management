package com.amagana.fms_ai_server.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductRequestDTO(String reference,String name, String description, BigDecimal purchase_price,
                                BigDecimal selling_price, String unit, boolean active, Long category) {
}
