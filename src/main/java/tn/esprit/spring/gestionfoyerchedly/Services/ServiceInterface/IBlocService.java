package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import java.util.List;

public interface IBlocService {
	List<Bloc> retrieveBlocs();
	Bloc addBloc(Bloc bloc);
	Bloc updateBloc(Bloc bloc);
	Bloc retrieveBloc(long idBloc);
	void removeBloc(long idBloc);
}
