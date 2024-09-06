package com.ecommerce.bookmyshow.dtos;

import com.ecommerce.bookmyshow.Models.Booking;
import lombok.Data;

@Data
public class BookingMovieResponseDTO {

    private Booking booking;
    private ResponseStatus status;


}
