package com.reservation.service.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long reservationId;

    @Column(name = "GUEST_ID")
    private long guestId;

    @Column(name = "ROOM_ID")
    private long roomId;

    @Column(name = "CHECK_IN")
    private String checkIn;

    @Column(name = "CHECK_OUT")
    private String checkOut;

    @Column(name = "RESERVATION_DATE")
    private String reservationDate;
}