package com.ecommerce.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Movie extends BaseModel {

    @ManyToMany
    private List<Actor> actors;
    private String name;


    /*
    Movie Actors => M:M
    1       m
    m        1

     */
}
