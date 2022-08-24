package com.reservation.service.service;

import com.reservation.service.entity.Reservation;
import com.reservation.service.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getReservationsByDate(String reservationDate) {

        return reservationRepository.getReservationsByDate(reservationDate);
    }

    public boolean registereRoomForGuist(Reservation reservation) {

        reservationRepository.save(reservation);

        return reservationRepository.existsById(reservation.getReservationId());

    }

    public boolean cancelTheReservation(Reservation reservation) {

        reservationRepository.deleteById(reservation.getReservationId());

        return !reservationRepository.existsById(reservation.getReservationId());

    }


    public boolean updateTheReservation(Reservation reservation) {

        //check the room is available on the particular dates if available then update
        //otherwise updated should be false

        Optional<Reservation> dbObject = reservationRepository.findById(reservation.getReservationId());

        System.out.println(dbObject);

        if (dbObject.get().getReservationId() == reservation.getReservationId()) {
            reservationRepository.save(reservation);
        } else {

        }

        return reservationRepository.existsById(reservation.getReservationId());

    }
}
