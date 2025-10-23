package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/getBloc/{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/removeBloc/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        blocService.removeBloc(idBloc);
    }
}
