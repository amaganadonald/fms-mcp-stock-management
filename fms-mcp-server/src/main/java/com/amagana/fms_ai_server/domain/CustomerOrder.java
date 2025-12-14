package com.amagana.fms_ai_server.domain;

import com.amagana.fms_ai_server.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CustomerOrder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_order_seq_id")
    @SequenceGenerator(name = "customer_order_seq_id", allocationSize = 1)
    private Long id;
    private String customerOrderNumber;
    private LocalDateTime customerOrderDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customers customer;
    private BigDecimal totalAmount;

}
