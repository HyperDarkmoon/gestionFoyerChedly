package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;
import java.util.List;

public interface IUniversiteService {
	List<Universite> retrieveAllUniversities();
	Universite addUniversite(Universite u);
	Universite updateUniversite(Universite u);
	Universite retrieveUniversite(long idUniversite);

	// Assign a foyer to the university found by its name
	Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

	// Unassign/clear the foyer from a university by id
	Universite desaffecterFoyerAUniversite(long idUniversite);
}

