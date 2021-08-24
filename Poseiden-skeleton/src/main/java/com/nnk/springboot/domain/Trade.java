package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trade")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tradeId;
    @Column(name = "account")
    private String account;
    @Column(name = "type")
    private String type;
    @Column(name = "buy_quantity")
    @NotNull(message = "must not be null")
    private Double buyQuantity;

}
