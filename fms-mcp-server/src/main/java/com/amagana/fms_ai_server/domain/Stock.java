package com.amagana.fms_ai_server.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "stocks", uniqueConstraints = @UniqueConstraint(columnNames = "product_id"))
public class Stock extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_seq_id")
    @SequenceGenerator(name = "stock_seq_id", allocationSize = 1)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;
    private Integer quantity;
    private Integer alertThreshold;

}
