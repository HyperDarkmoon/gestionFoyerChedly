package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import java.util.List;

public interface IChambreService {
	List<Chambre> retrieveAllChambres();
	Chambre addChambre(Chambre c);
	Chambre updateChambre(Chambre c);
	Chambre retrieveChambre(long idChambre);
}
