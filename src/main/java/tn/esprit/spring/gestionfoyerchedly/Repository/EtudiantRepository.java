package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.gestionfoyerchedly.Entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}

