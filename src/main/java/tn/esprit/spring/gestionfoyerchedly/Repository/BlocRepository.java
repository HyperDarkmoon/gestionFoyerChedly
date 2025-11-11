package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {
	// Derived query: traverse Bloc -> Foyer -> Universite -> nomUniversite
	List<Bloc> findByFoyerUniversiteNomUniversite(String nom);
}


