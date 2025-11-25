package tn.esprit.spring.gestionfoyerchedly.services.ServiceInterfaces;

import tn.esprit.spring.gestionfoyerchedly.entities.Etudiant;

import java.util.List;

public interface EtudiantServiceInterfaces {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}
