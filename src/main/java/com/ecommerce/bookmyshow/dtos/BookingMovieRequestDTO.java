package com.ecommerce.bookmyshow.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookingMovieRequestDTO {
    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;
}
