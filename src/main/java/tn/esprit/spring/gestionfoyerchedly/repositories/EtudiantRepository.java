package tn.esprit.spring.gestionfoyerchedly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.gestionfoyerchedly.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCin(long cin);
}
