package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curve_point")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "curve_id")
    @NotNull(message = "must not be null")
    private Integer curveId;
    @Column(name = "value")
    @NotNull(message = "must not be null")
    private Double value;
    @Column(name = "term")
    @NotNull(message = "must not be null")
    private Double term;
}
