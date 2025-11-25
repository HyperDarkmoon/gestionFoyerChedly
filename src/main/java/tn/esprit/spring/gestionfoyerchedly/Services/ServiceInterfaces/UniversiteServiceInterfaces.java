package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces;

import java.util.List;

import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;

public interface UniversiteServiceInterfaces {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite(Universite u);
    Universite updateUniversite(Universite u);
    Universite retrieveUniversite(long idUniversite);
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite(long idUniversite);
}
