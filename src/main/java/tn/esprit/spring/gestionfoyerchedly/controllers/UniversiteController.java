package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Universite;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IUniversiteService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Universite", description = "Operations related to Universite resources")
public class UniversiteController {
    private final IUniversiteService universiteService;

    public UniversiteController(IUniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping("/getAllUniversites")
    @Operation(summary = "List all universites", description = "Retrieve the complete list of universities")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of universities returned successfully")
    })
    public List<Universite> retrieveUniversites() {
        return universiteService.retrieveAllUniversities();
    }

    @PostMapping("/addUniversite")
    @Operation(summary = "Create an universite", description = "Add a new university")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "University created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload")
    })
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    @Operation(summary = "Update an universite", description = "Update an existing university")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "University updated successfully"),
            @ApiResponse(responseCode = "404", description = "University not found")
    })
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("/getUniversite/{idUniversite}")
    @Operation(summary = "Get an universite by ID", description = "Retrieve a single university by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "University returned successfully"),
            @ApiResponse(responseCode = "404", description = "University not found")
    })
    public Universite retrieveUniversite(@PathVariable @Parameter(description = "University identifier") long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }
}
