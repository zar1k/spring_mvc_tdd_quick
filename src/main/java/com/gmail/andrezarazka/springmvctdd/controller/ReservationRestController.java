package com.gmail.andrezarazka.springmvctdd.controller;

import com.gmail.andrezarazka.springmvctdd.model.Reservation;
import com.gmail.andrezarazka.springmvctdd.repository.ReservationRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class ReservationRestController {

    private final ReservationRepository repository;

    public ReservationRestController(ReservationRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/reservations", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Collection<Reservation> reservations() {
        return this.repository.findAll();
    }
}
