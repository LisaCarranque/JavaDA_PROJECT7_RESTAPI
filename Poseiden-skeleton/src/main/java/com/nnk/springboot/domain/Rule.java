package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rule_name")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "json")
    private String json;
    @Column(name = "template")
    private String template;
    @Column(name = "sql_str")
    private String sqlStr;
    @Column(name = "sql_part")
    private String sqlPart;
}
