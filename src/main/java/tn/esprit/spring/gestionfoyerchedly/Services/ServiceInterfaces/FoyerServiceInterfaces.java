package tn.esprit.spring.gestionfoyerchedly.services.ServiceInterfaces;

import tn.esprit.spring.gestionfoyerchedly.entities.Foyer;

import java.util.List;

public interface FoyerServiceInterfaces {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    Foyer retrieveFoyer(long idFoyer);
    void removeFoyer(long idFoyer);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
