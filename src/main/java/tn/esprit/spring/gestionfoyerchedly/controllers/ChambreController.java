package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Chambre;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IChambreService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Chambre", description = "Operations related to Chambre resources")
public class ChambreController {
    private final IChambreService chambreService;

    public ChambreController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("/getAllChambres")
    @Operation(summary = "List all chambres", description = "Retrieve the complete list of chambres")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of chambres returned successfully")
    })
    public List<Chambre> retrieveChambres() {
        return chambreService.retrieveAllChambres();
    }

    @PostMapping("/addChambre")
    @Operation(summary = "Create a chambre", description = "Add a new chambre")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Chambre created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload")
    })
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/updateChambre")
    @Operation(summary = "Update a chambre", description = "Update an existing chambre")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chambre updated successfully"),
            @ApiResponse(responseCode = "404", description = "Chambre not found")
    })
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/getChambre/{idChambre}")
    @Operation(summary = "Get a chambre by ID", description = "Retrieve a single chambre by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chambre returned successfully"),
            @ApiResponse(responseCode = "404", description = "Chambre not found")
    })
    public Chambre retrieveChambre(@PathVariable @Parameter(description = "Chambre identifier") long idChambre) {
        return chambreService.retrieveChambre(idChambre);
    }
}
