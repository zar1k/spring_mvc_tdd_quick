package com.gmail.andrezarazka.springmvctdd.service;

import com.gmail.andrezarazka.springmvctdd.model.Reservation;
import com.gmail.andrezarazka.springmvctdd.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation addReservation(Reservation reservation) {
        return this.repository.save(reservation);
    }

    public List<Reservation> getReservations() {
        return repository.findAll();
    }

    public List<Reservation> getByReservationName(String name) {
        return this.repository.findByReservationName(name);
    }

    public void deleteReservation(Reservation reservation) {
        this.repository.delete(reservation);
    }
}
