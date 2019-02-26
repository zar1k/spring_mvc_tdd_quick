package com.gmail.andrezarazka.springmvctdd.controller;

import com.gmail.andrezarazka.springmvctdd.model.Reservation;
import com.gmail.andrezarazka.springmvctdd.service.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ReservationRestController {

    private final ReservationService service;

    public ReservationRestController(ReservationService service) {
        this.service = service;
    }

    @GetMapping(path = "/reservations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Collection<Reservation> reservations() {
        return this.service.getReservations();
    }
}
