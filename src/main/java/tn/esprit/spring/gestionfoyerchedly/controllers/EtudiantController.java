package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Etudiant;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IEtudiantService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Etudiant", description = "Operations related to Etudiant resources")
public class EtudiantController {
    private final IEtudiantService etudiantService;

    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/getAllEtudiants")
    @Operation(summary = "List all etudiants", description = "Retrieve the complete list of students")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of students returned successfully")
    })
    public List<Etudiant> retrieveEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiants")
    @Operation(summary = "Create etudiants", description = "Add multiple students in bulk")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Students created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload")
    })
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/updateEtudiant")
    @Operation(summary = "Update an etudiant", description = "Update an existing student")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/getEtudiant/{idEtudiant}")
    @Operation(summary = "Get an etudiant by ID", description = "Retrieve a single student by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Student returned successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public Etudiant retrieveEtudiant(@PathVariable @Parameter(description = "Student identifier") long idEtudiant) {
        return etudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/removeEtudiant/{idEtudiant}")
    @Operation(summary = "Delete an etudiant", description = "Remove a student by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public void removeEtudiant(@PathVariable @Parameter(description = "Student identifier") long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
