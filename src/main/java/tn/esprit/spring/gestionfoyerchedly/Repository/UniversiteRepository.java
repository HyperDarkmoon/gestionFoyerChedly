package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {
	Universite findByNomUniversite(String nomUniversite);
}
