package tn.esprit.spring.gestionfoyerchedly.services.ServiceInterfaces;

import tn.esprit.spring.gestionfoyerchedly.entities.Universite;

import java.util.List;

public interface UniversiteServiceInterfaces {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    Universite retrieveUniversite(long idUniversite);
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite(long idUniversite);
}
