package com.ecommerce.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Data;
@Entity
@Data
public class SeatType  extends BaseModel {
    private String name;

}
