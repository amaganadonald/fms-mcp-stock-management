package com.amagana.fms_ai_server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Customers extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_id")
    @SequenceGenerator(name = "customer_seq_id", allocationSize = 1)
    private Long id;
    private String code;
    private String nom;
    private String phone;
    private String mail;
    private String address;
}
