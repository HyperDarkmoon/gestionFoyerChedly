package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Reservation;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IReservationService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Reservation", description = "Operations related to Reservation resources")
public class ReservationController {
    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAllReservations")
    @Operation(summary = "List all reservations", description = "Retrieve the complete list of reservations")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of reservations returned successfully")
    })
    public List<Reservation> retrieveReservations() {
        return reservationService.retrieveAllReservation();
    }

    @PutMapping("/updateReservation")
    @Operation(summary = "Update a reservation", description = "Update an existing reservation")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation updated successfully"),
            @ApiResponse(responseCode = "404", description = "Reservation not found")
    })
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/getReservation/{idReservation}")
    @Operation(summary = "Get a reservation by ID", description = "Retrieve a single reservation by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation returned successfully"),
            @ApiResponse(responseCode = "404", description = "Reservation not found")
    })
    public Reservation retrieveReservation(@PathVariable @Parameter(description = "Reservation identifier") long idReservation) {
        return reservationService.retrieveReservation(idReservation);
    }
}
