package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Bloc;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IBlocService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@Tag(name = "Bloc", description = "Operations related to Bloc resources")
public class BlocController {
    private final IBlocService blocService;

    public BlocController(IBlocService blocService) {
        this.blocService = blocService;
    }

    @GetMapping("/getAllBlocs")
    @Operation(summary = "List all blocs", description = "Retrieve the complete list of blocs")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of blocs returned successfully")
    })
    public List<Bloc> retrieveBlocs() {
        return blocService.retrieveBlocs();
    }

    @PostMapping("/addBloc")
    @Operation(summary = "Create a bloc", description = "Add a new bloc")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Bloc created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Bloc to create",
        required = true,
        content = @Content(mediaType = "application/json",
            examples = {
                @ExampleObject(name = "Basic",
                    value = "{\n  \"nomBloc\": \"Bloc A\",\n  \"capaciteBloc\": 120\n}")
            })
    )
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/updateBloc")
    @Operation(summary = "Update a bloc", description = "Update an existing bloc")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Bloc updated successfully"),
            @ApiResponse(responseCode = "404", description = "Bloc not found")
    })
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/getBloc/{idBloc}")
    @Operation(summary = "Get a bloc by ID", description = "Retrieve a single bloc by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Bloc returned successfully"),
            @ApiResponse(responseCode = "404", description = "Bloc not found")
    })
    public Bloc retrieveBloc(@PathVariable @Parameter(description = "Bloc identifier") long idBloc) {
        return blocService.retrieveBloc(idBloc);
    }

    @DeleteMapping("/removeBloc/{idBloc}")
    @Operation(summary = "Delete a bloc", description = "Remove a bloc by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Bloc deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Bloc not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBloc(@PathVariable @Parameter(description = "Bloc identifier") long idBloc) {
        blocService.removeBloc(idBloc);
    }

    @GetMapping("/blocs/by-universite")
    @Operation(summary = "Find blocs by universite name", description = "Retrieve blocs associated to a given university name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of blocs returned successfully")
    })
    public List<Bloc> findBlocsByUniversite(@RequestParam("nom") @Parameter(description = "University name") String nom) {
        return blocService.findByFoyerUniversiteNomUniversite(nom);
    }

    @PutMapping("/blocs/affecter-chambres")
    @Operation(summary = "Assign chambres to a bloc",
        description = "Attach multiple chambres to a bloc using their numbers")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Chambres assigned to bloc successfully"),
        @ApiResponse(responseCode = "404", description = "Bloc or chambres not found")
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "List of chambre numbers",
        required = true,
        content = @Content(mediaType = "application/json",
            examples = {
                @ExampleObject(name = "Numbers",
                    value = "[101, 102, 103]")
            })
    )
    public Bloc affecterChambresABloc(@RequestBody List<Double> numChambre,
                      @RequestParam("IdBloc") @Parameter(description = "Bloc identifier", example = "1") int IdBloc) {
    return blocService.affecterChambresABloc(numChambre, IdBloc);
    }
}
