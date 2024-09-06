package com.ecommerce.bookmyshow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends BaseModel {

    private String name;

    //private List<Theatre> theatres;

}
