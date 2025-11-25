package tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterfaces;

import java.util.List;

import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;

public interface BlocServiceInterfaces {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc(Bloc bloc);
    Bloc addBloc(Bloc bloc);
    Bloc retrieveBloc(long idBloc);
    void removeBloc(long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
    List<Bloc> getBlocsByNomUniversite(String nomUniversite);
}
