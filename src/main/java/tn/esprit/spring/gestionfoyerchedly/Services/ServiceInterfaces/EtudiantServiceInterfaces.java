package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces;

import java.util.List;

import tn.esprit.spring.gestionfoyerchedly.Entity.Etudiant;

public interface EtudiantServiceInterfaces {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}
