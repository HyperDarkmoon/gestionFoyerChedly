package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces;

import java.util.List;

import tn.esprit.spring.gestionfoyerchedly.Entity.Foyer;

public interface FoyerServiceInterfaces {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    Foyer retrieveFoyer(long idFoyer);
    void removeFoyer(long idFoyer);
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
