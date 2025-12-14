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
public class CustomerOrderLine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_order_seq_id")
    @SequenceGenerator(name = "customer_order_seq_id", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private CustomerOrder customerOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customers customers;

    private Integer quantity;
    private BigDecimal unitPrice;
}
