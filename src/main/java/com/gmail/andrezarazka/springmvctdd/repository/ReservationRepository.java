package com.gmail.andrezarazka.springmvctdd.repository;

import com.gmail.andrezarazka.springmvctdd.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Collection<Reservation> findByReservationName(String name);

}
