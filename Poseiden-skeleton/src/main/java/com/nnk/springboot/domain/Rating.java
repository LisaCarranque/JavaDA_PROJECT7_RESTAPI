package com.nnk.springboot.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "rating")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name="moodys_rating")
    private String moodysRating;
    @Column(name="sand_p_rating")
    private String sandPRating;
    @Column(name="fitch_rating")
    private String fitchRating;
    @Column(name="order_number")
    private Integer orderNumber;
}
