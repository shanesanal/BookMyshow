package com.ecommerce.bookmyshow.services;

import com.ecommerce.bookmyshow.Models.SeatType;
import com.ecommerce.bookmyshow.Models.Show;
import com.ecommerce.bookmyshow.Models.ShowSeat;
import com.ecommerce.bookmyshow.Models.ShowSeatType;
import com.ecommerce.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PriceCalculationService {

    ShowSeatTypeRepository showSeatTypeRepository;
    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }


    public int calculatePrice(List<ShowSeat> showSeats, Show show ){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        int totalAmount = 0;

        for(ShowSeat showSeat: showSeats){
            SeatType seatType = showSeat.getSeat().getSeatType();
//           Optional<ShowSeatType> showSeat1 =showSeatTypeRepository.findBySeatType(seatType);
//            totalAmount += showSeat1.get().getPrice();
            for(ShowSeatType showSeatType:showSeatTypes)
            {
                if(showSeatType.getSeatType() == seatType)
                {
                    totalAmount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return totalAmount;
    }
}
