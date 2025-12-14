package com.amagana.fms_ai_server.dto;

import lombok.Builder;

@Builder
public record CustomerRequestDTO(String code,String nom,String phone,String mail,String address) {
}
