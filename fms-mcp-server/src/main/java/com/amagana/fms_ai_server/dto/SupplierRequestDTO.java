package com.amagana.fms_ai_server.dto;

import lombok.Builder;

@Builder
public record SupplierRequestDTO(String code,String name,String phone,String email,
                                 String address,boolean active) {
}
