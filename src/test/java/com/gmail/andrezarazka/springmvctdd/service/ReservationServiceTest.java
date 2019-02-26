package com.gmail.andrezarazka.springmvctdd.service;

import com.gmail.andrezarazka.springmvctdd.model.Reservation;
import com.gmail.andrezarazka.springmvctdd.repository.ReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ReservationServiceTest {

//    @Autowired
    @InjectMocks
    private ReservationService service;

//    @MockBean
    @Mock
    private ReservationRepository repository;

    @Test
    public void addReservationTest() {
        Reservation reservation = new Reservation(1L, "Jane");
        when(this.repository.save(reservation)).thenReturn(reservation);

        assertEquals(reservation, this.service.addReservation(reservation));
    }

    @Test
    public void getReservationsTest() {
        when(this.repository.findAll())
                .thenReturn(Stream.of(new Reservation(1L, "Jane"), new Reservation(2L, "Tim"))
                        .collect(Collectors.toList()));

        assertEquals(2, this.service.getReservations().size());
    }

    @Test
    public void getByReservationNameTest() {
        String name = "Tim";
        when(this.repository.findByReservationName(name))
                .thenReturn(Stream.of(new Reservation(2L, "Tim"))
                        .collect(Collectors.toList()));

        assertEquals(1, this.service.getByReservationName(name).size());
    }

    @Test
    public void deleteReservationTest() {
        Reservation reservation = new Reservation(1L, "Jane");

        this.service.deleteReservation(reservation);
        verify(this.repository, times(1)).delete(reservation);
    }
}