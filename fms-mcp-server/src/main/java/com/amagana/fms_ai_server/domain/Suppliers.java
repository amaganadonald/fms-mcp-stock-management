package com.amagana.fms_ai_server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "supplier_seq", allocationSize = 1)
    private Long id;
    private String code;
    private String name;
    private String phone;
    private String email;
    private String address;
    private boolean active;
    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders = new ArrayList<>();
}
