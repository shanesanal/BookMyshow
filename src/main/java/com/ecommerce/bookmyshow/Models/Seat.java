package com.ecommerce.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {

    private String number;

    @ManyToOne
    private SeatType seatType;


    private int rowVal;
    private int colVal;
}

/*
seat seatType
1      1
m       1
 */