package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.gestionfoyerchedly.Entity.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCin(long cin);
}
