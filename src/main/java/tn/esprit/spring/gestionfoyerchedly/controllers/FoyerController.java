package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Foyer;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IFoyerService;

import java.util.List;

@RestController
public class FoyerController {
    private final IFoyerService foyerService;

    public FoyerController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @GetMapping("/getAllFoyers")
    public List<Foyer> retrieveFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/getFoyer/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("/removeFoyer/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }
}
