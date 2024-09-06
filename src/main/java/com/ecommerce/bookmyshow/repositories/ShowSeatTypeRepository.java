package com.ecommerce.bookmyshow.repositories;

import com.ecommerce.bookmyshow.Models.SeatType;
import com.ecommerce.bookmyshow.Models.Show;
import com.ecommerce.bookmyshow.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    List<ShowSeatType> findAllByShow(Show show);


    Optional<ShowSeatType> findBySeatType(SeatType seatType);
}
