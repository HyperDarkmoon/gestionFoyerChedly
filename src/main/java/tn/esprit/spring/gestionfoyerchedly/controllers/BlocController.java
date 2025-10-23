package tn.esprit.spring.gestionfoyerchedly.controllers;

import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IBlocService;

import java.util.List;

public class BlocController {
    IBlocService blocService;

    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }

    public Bloc addBloc(Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    public Bloc updateBloc(Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    public Bloc retrieveBloc(long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    public void removeBloc(long idBloc) {
        blocService.removeBloc(idBloc);
    }
}
