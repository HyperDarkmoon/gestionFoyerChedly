package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Reservation;
import java.util.List;

public interface IReservationService {
	List<Reservation> retrieveAllReservation();
	Reservation updateReservation(Reservation res);
	Reservation retrieveReservation(String idReservation);
}


