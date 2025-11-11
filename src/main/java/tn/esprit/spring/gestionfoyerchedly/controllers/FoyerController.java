package tn.esprit.spring.gestionfoyerchedly.controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyerchedly.Entity.Foyer;
import tn.esprit.spring.gestionfoyerchedly.Services.ServiceInterface.IFoyerService;

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
@Tag(name = "Foyer", description = "Operations related to Foyer resources")
public class FoyerController {
    private final IFoyerService foyerService;

    public FoyerController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @GetMapping("/getAllFoyers")
    @Operation(summary = "List all foyers", description = "Retrieve the complete list of foyers")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of foyers returned successfully")
    })
    public List<Foyer> retrieveFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/addFoyer")
    @Operation(summary = "Create a foyer", description = "Add a new foyer")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Foyer created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request payload")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        description = "Foyer to create",
        required = true,
        content = @Content(mediaType = "application/json",
            examples = {
                @ExampleObject(name = "Basic",
                    value = "{\n  \"nomFoyer\": \"Foyer Central\",\n  \"capaciteFoyer\": 500\n}")
            })
    )
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/updateFoyer")
    @Operation(summary = "Update a foyer", description = "Update an existing foyer")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foyer updated successfully"),
            @ApiResponse(responseCode = "404", description = "Foyer not found")
    })
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/getFoyer/{idFoyer}")
    @Operation(summary = "Get a foyer by ID", description = "Retrieve a single foyer by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foyer returned successfully"),
            @ApiResponse(responseCode = "404", description = "Foyer not found")
    })
    public Foyer retrieveFoyer(@PathVariable @Parameter(description = "Foyer identifier") long idFoyer) {
        return foyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("/removeFoyer/{idFoyer}")
    @Operation(summary = "Delete a foyer", description = "Remove a foyer by its identifier")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Foyer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Foyer not found")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFoyer(@PathVariable @Parameter(description = "Foyer identifier") long idFoyer) {
        foyerService.removeFoyer(idFoyer);
    }
}
