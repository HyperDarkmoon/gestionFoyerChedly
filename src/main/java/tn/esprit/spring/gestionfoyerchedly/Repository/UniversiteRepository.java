package tn.esprit.spring.gestionfoyerchedly.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.gestionfoyerchedly.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
	Universite findByNomUniversite(String nomUniversite);
}
