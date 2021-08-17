package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Table(name = "curve_point")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurvePoint {
    // TODO: Map columns in data table CURVEPOINT with corresponding java fields
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="curve_id")
    @NotNull
    private Integer curveId;
    @Column(name="value")
    private Double value;
    @Column(name="term")
    private Double term;
}
