package com.ecommerce.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Entity
@Getter
@Setter
public class Booking extends BaseModel {

    @ManyToMany
    private List<ShowSeat> ShowSeats;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private int amount;

    @OneToMany
    private List<Payment> payments;

}
/*
   1         M
Booking  ShowSeats   => M:M
   M         1

    1         1
   Booking  User
     m         1

 Booking  Payment
    1        M
    1         1
 */