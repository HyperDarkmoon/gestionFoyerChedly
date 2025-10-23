package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}

