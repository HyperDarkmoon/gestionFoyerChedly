package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
	// Derived query traversing Bloc.foyer.universite.nomUniversite
	List<Bloc> findByFoyerUniversiteNomUniversite(String nom);
}
