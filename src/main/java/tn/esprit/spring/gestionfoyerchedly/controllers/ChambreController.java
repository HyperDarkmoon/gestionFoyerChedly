package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IChambreService;

import java.util.List;

@RestController
public class ChambreController {
    private final IChambreService chambreService;

    public ChambreController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("/getAllChambres")
    public List<Chambre> retrieveChambres() {
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/updateChambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/getChambre/{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) {
        return chambreService.retrieveChambre(idChambre);
    }
}
