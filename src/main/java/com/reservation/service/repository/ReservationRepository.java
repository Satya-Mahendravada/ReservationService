package com.reservation.service.repository;

import com.reservation.service.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query(value = "select * from reservation where reservation_date = :reservationDate", nativeQuery = true)
    List<Reservation> getReservationsByDate(String reservationDate);

}