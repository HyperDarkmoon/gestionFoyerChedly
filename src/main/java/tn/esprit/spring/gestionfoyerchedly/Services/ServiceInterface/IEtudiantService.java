package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface;

import tn.esprit.spring.gestionfoyerchedly.Entity.Etudiant;
import java.util.List;

public interface IEtudiantService {
	List<Etudiant> retrieveAllEtudiants();
	List<Etudiant> addEtudiants(List<Etudiant> etudiants);
	Etudiant updateEtudiant(Etudiant e);
	Etudiant retrieveEtudiant(long idEtudiant);
	void removeEtudiant(long idEtudiant);
}
