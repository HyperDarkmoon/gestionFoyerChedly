package tn.esprit.spring.gestionfoyerchedly.Services.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.gestionfoyerchedly.Entity.Reservation;
import tn.esprit.spring.gestionfoyerchedly.Repository.ReservationRepository;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IReservationService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }
}
