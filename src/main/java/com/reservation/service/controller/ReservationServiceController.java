package com.reservation.service.controller;

import com.reservation.service.entity.Reservation;
import com.reservation.service.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class ReservationServiceController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(path = "/reservations", method = GET)
    public List<Reservation> getAllReservations(@RequestParam(value = "date", required = false) String reservationDate) {
        //which will show you all the reserved rooms on a perticular date
        //ResponseEntity<List<Reservation>> responseEntity = new ResponseEntity<>();
        return reservationService.getReservationsByDate(reservationDate);
    }

    @RequestMapping(path = "/reserve-room", method = POST)
    public boolean reserveRoom(@RequestBody Reservation reservation) {

        //check whether the rooms are available on the particular date
        //if available book the room

        //BED_INFO

       /* Reservation reservation = new Reservation();
        reservation.setCheckIn("21/08/2022");
        reservation.setCheckOut("25/08/2022");
        reservation.setReservationDate("13/08/2022");
        reservation.setRoomId(621);*/

        boolean status = reservationService.registereRoomForGuist(reservation);

        //update the roombooked status to RoomService

        //Room Servicemakes the RoomStatus Available to true

        return status;


    }

    @RequestMapping(path = "/cancel-reservation", method = DELETE)
    public boolean cancelReservedRoom(@RequestBody Reservation reservation) {

        //Received the CancelRequest

       /* Reservation reservation = new Reservation();
        reservation.setReservationId(1);
        reservation.setCheckIn("21/08/2022");
        reservation.setCheckOut("25/08/2022");
        reservation.setReservationDate("13/08/2022");
        reservation.setRoomId(621);*/
        boolean status = reservationService.cancelTheReservation(reservation);

        //update the RoomStatus to RoomService
        //RoomService Make the RoomStatus Available to True

        return status;
    }

    @RequestMapping(path = "/update-reserved-room", method = PATCH)
    public boolean updatereservedRoom(@RequestBody Reservation reservation) {
        //
        /*Reservation reservation = new Reservation();
        reservation.setReservationId(2);
        reservation.setCheckIn("25/08/2022");
        reservation.setCheckOut("27/08/2022");
        reservation.setReservationDate("13/08/2022");
        reservation.setRoomId(621);*/

        reservationService.updateTheReservation(reservation);
        return true;
    }


}
