package com.ecommerce.bookmyshow.services;

import com.ecommerce.bookmyshow.Models.*;
import com.ecommerce.bookmyshow.repositories.ShowRepository;
import com.ecommerce.bookmyshow.repositories.ShowSeatRepository;
import com.ecommerce.bookmyshow.repositories.UserRepository;
import exceptions.SeatsNotAvailableExceptions;
import exceptions.ShowNoFoundException;
import exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

        private UserRepository userRepository;
        private ShowRepository showRepository;
        private ShowSeatRepository showSeatRepository;
        private PriceCalculationService priceCalculationService;

        public BookingService(UserRepository userRepository,ShowRepository showRepository, ShowSeatRepository showSeatRepository, PriceCalculationService priceCalculationService) {
                this.userRepository = userRepository;
                this.showRepository = showRepository;
                this.showSeatRepository = showSeatRepository;
                this.priceCalculationService = priceCalculationService;
        }


        @Transactional(isolation = Isolation.SERIALIZABLE)
        public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNoFoundException, SeatsNotAvailableExceptions {

               Optional<User> optionalUser  = userRepository.findById(userId);
               if(optionalUser.isEmpty()) {

                       //go to the login workflow, ask the user to register
                       throw new UserNotFoundException("User with userId: " + userId + " not found");

               }
               User user = optionalUser.get();

               Optional<Show> optionsShow = showRepository.findById(showId);
               if(optionsShow.isEmpty()) {
                       throw new ShowNoFoundException("Show with showId: " + showId + " not found");
               }

               Show show = optionsShow.get();

               List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

               if(showSeats.size() ==0) {
                       throw new RuntimeException("Please select some seats");
               }
               for(ShowSeat showSeat: showSeats) {
                     if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
                     {
                        throw new SeatsNotAvailableExceptions("Some of the seats are not available");
                     }
               }

               for(ShowSeat showSeat: showSeats) {
                       showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
                       showSeatRepository.save(showSeat);
               }
               //create a booking and move to payment gateway

                Booking booking = new Booking();
                booking.setUser(user);
                booking.setShowSeats(showSeats);
                booking.setBookingStatus(BookingStatus.PENDING);
                booking.setAmount(priceCalculationService.calculatePrice(showSeats, show));

                return booking;
        }
}
