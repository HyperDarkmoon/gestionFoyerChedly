package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import java.util.List;

public interface IBlocService {
	List<Bloc> retrieveBlocs();
	Bloc addBloc(Bloc bloc);
	Bloc updateBloc(Bloc bloc);
	Bloc retrieveBloc(long idBloc);
	void removeBloc(long idBloc);

	// Find blocs by the associated universite name
	List<Bloc> findByFoyerUniversiteNomUniversite(String nom);

	// Assign chambres to a bloc by chambre numbers
	Bloc affecterChambresABloc(List<Double> numChambre, int IdBloc);
}
