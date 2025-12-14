package com.amagana.fms_ai_server.domain;

import com.amagana.fms_ai_server.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SupplierOrder extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_order_seq_id")
    @SequenceGenerator(name = "supplier_order_seq_id", allocationSize = 1)
    private Long id;
    private String numero;
    private LocalDateTime supplierOrderDate;
    private LocalDateTime expectedDeliveryDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;
    private BigDecimal totalAmount;
    @OneToMany(mappedBy = "supplierOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierOrderLine> supplierOrderLines = new ArrayList<>();

}
