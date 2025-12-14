package com.amagana.fms_ai_server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SupplierOrderLine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_order_seq_id")
    @SequenceGenerator(name = "supplier_order_seq_id", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private SupplierOrder supplierOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Suppliers suppliers;

    private Integer quantity;
    private BigDecimal unitPrice;
}
