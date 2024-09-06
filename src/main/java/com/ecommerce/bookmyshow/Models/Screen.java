package com.ecommerce.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Screen extends BaseModel {

    private String name;

    @OneToMany
    private List<Seat> seats;
    //what the error with this line
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    /*
    Screen Seats => 1:M

    Screen Feature
    1        m
     m         1
     */
}
