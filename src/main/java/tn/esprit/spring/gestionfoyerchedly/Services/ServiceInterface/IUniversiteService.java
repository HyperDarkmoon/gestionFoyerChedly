package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite(Universite u);

    Universite updateUniversite(Universite u);

    Universite retrieveUniversite(long idUniversite);
}

