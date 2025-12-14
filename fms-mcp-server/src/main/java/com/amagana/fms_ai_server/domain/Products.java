package com.amagana.fms_ai_server.domain;

import com.amagana.fms_ai_server.enums.Units;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "products")
public class Products extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq_id")
    @SequenceGenerator(name = "customer_seq_id", allocationSize = 1)
    private Long id;
    @Column(unique = true, nullable = false)
    private String reference;
    private String name;
    private String description;
    private BigDecimal purchase_price;
    private BigDecimal selling_price;
    @Enumerated(EnumType.STRING)
    private Units units;
    private boolean active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
