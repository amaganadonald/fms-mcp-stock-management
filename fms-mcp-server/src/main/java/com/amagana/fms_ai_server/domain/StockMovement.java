package com.amagana.fms_ai_server.domain;

import com.amagana.fms_ai_server.enums.MovementSource;
import com.amagana.fms_ai_server.enums.MovementType;
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
public class StockMovement extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_movement_seq_id")
    @SequenceGenerator(name = "stock_movement_seq_id", allocationSize = 1)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Products products;
    @Enumerated(EnumType.STRING)
    private MovementType movementType;
    private Integer quantity;
    private Integer stockBefore;
    private Integer stockAfter;
    private String reason;
    private LocalDateTime movement_date;
    private String reference_source;
    @Enumerated(EnumType.STRING)
    private MovementSource source;
    private String comments;
}
