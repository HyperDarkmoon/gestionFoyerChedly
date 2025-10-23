package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.gestionfoyerchedly.Entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {
}


