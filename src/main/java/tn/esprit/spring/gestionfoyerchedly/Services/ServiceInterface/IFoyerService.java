package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer f);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(long idFoyer);

    void removeFoyer(long idFoyer);
}
