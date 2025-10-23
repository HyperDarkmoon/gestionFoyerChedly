package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Reservation;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IReservationService;

import java.util.List;

@RestController
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> retrieveReservations() {
        return reservationService.retrieveAllReservation();
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/getReservation/{idReservation}")
    public Reservation retrieveReservation(@PathVariable String idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }
}
