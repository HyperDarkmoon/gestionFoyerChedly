package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IUniversiteService;

import java.util.List;

@RestController
public class UniversiteController {
    private final IUniversiteService universiteService;

    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping("/getAllUniversites")
    public List<Universite> retrieveUniversites() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("/getUniversite/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
}
