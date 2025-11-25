package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.gestionfoyerchedly.Entity.Reservation;

public interface ReservationServiceInterfaces {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation(Reservation res);
    Reservation retrieveReservation(long idReservation);
    Reservation ajouterReservation(long idChambre, long cinEtudiant);

    // Partie 5
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
}
