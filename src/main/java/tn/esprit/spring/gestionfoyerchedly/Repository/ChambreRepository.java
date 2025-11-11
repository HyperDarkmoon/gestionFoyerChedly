package tn.esprit.spring.gestionfoyerchedly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Entity.TypeChambre;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
	// Derived query: typeC AND bloc.foyer.capaciteFoyer
	List<Chambre> findByTypeCAndBlocFoyerCapaciteFoyer(TypeChambre typeC, long capaciteFoyer);

	// Find chambres by list of numbers
	List<Chambre> findByNumeroChambreIn(List<Long> numeros);
}

