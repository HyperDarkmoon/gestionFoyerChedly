package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces;

import java.util.List;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Entity.TypeChambre;

public interface ChambreServiceInterfaces {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre(Chambre c);
    Chambre retrieveChambre(long idChambre);

    // Partie 5
    List<Chambre> getChambresParNomUniversite(String nomUniversite);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    List<Chambre> affecterChambresABloc(List<Long> numChambre, long idBloc);

    List<Chambre> getChambresByTypeCAndBlocFoyerCapaciteFoyer(TypeChambre type, long c);

}
