package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name = "bid_list")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BidList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bidListId;
    @Column(name = "bid_quantity")
    private Double bidQuantity;
    @Column(name = "account")
    @NotBlank(message = "Account is mandatory")
    private String account;
    @Column(name = "type")
    @NotBlank(message = "Type is mandatory")
    private String type;
    @Column(name = "ask_quantity")
    private Double askQuantity;
    @Column(name = "bid")
    private Double bid;
    @Column(name = "ask")
    private Double ask;
    @Column(name = "benchmark")
    private String benchmark;
    @Column(name = "bid_list_date")
    private Timestamp bidListDate;
    @Column(name = "commentary")
    private String commentary;
    @Column(name = "security")
    private String security;
    @Column(name = "status")
    private String status;
    @Column(name = "trader")
    private String trader;
    @Column(name = "book")
    private String book;
    @Column(name = "creation_name")
    private String creationName;
    @Column(name = "creation_date")
    private Timestamp creationDate;
    @Column(name = "revision_name")
    private String revisionName;
    @Column(name = "revision_date")
    private Timestamp revisionDate;
    @Column(name = "deal_name")
    private String dealName;
    @Column(name = "deal_type")
    private String dealType;
    @Column(name = "source_list_id")
    private String sourceListId;
    @Column(name = "side")
    private String side;

}
