package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IBlocService;

import java.util.List;

@RestController
public class BlocController {
    private final IBlocService blocService;

    public BlocController(IBlocService blocService) {
        this.blocService = blocService;
    }

    @GetMapping("/getAllBlocs")
    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
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
