package com.ecommerce.bookmyshow.Contollers;


import com.ecommerce.bookmyshow.Models.Booking;
import com.ecommerce.bookmyshow.dtos.BookingMovieRequestDTO;
import com.ecommerce.bookmyshow.dtos.BookingMovieResponseDTO;
import com.ecommerce.bookmyshow.dtos.ResponseStatus;
import com.ecommerce.bookmyshow.services.BookingService;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookingController {


    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    public BookingMovieResponseDTO bookMovie(BookingMovieRequestDTO bookingMovieRequestDTO) {


        BookingMovieResponseDTO bookingMovieResponseDTO = new BookingMovieResponseDTO();
        try {


            Booking booking = bookingService.bookMovie(
                    bookingMovieRequestDTO.getUserId(),
                    bookingMovieRequestDTO.getShowId(),
                    bookingMovieRequestDTO.getShowSeatIds()
            );

            bookingMovieResponseDTO.setBooking(booking);
            bookingMovieResponseDTO.setStatus(ResponseStatus.SUCCESS);

            return bookingMovieResponseDTO;
        } catch (Exception e) {
            bookingMovieResponseDTO.setStatus(ResponseStatus.FAILURE);
            return bookingMovieResponseDTO;
        }

    }

}
