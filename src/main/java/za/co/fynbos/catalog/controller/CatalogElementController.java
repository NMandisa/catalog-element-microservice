package za.co.fynbos.catalog.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.fynbos.catalog.response.CatalogElementResponse;
import za.co.fynbos.catalog.exception.CatalogElementNotFoundException;
import za.co.fynbos.catalog.service.CatalogElementService;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.domain.enums.LifecycleStatus;

@CrossOrigin(allowedHeaders = {"*"}, origins = "*")
@RestController
@RequestMapping("/catalog-elements")
@Tag(name = "Catalog Element")
public class CatalogElementController {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CatalogElementController.class.getName());
    private final CatalogElementService catalogElementService;
    @Autowired //Constructor Autowiring Dependency Injection
    public CatalogElementController(@Qualifier("defaultCatalogElementService") CatalogElementService catalogElementService){
        this.catalogElementService = catalogElementService;
    }
    @Operation(
            description = "Patch endpoint for catalog element lifecycle",
            summary = "This is a summary for catalog element lifecycle patch endpoint to update lifecycle",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "403"
                    ),
                    @ApiResponse(
                            description = "Catalog Element Not Found",
                            responseCode = "404"
                    )
            }

    )
    @PatchMapping(value = "/{id}/status", headers = "Accept=application/json")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody LifecycleStatus newStatus) {
        CatalogElement catalogElement = catalogElementService.getCatalogElementById(id);
        if(catalogElement==null) throw new CatalogElementNotFoundException("id :"+id);
        LifecycleStatus OldlifecycleStatus = catalogElement.getStatus();
        catalogElementService.validateAndUpdateStatus(catalogElement, newStatus);
        CatalogElementResponse catalogElementUpdatedStatusDTO =
                new CatalogElementResponse(catalogElement,OldlifecycleStatus,newStatus); // return informative response
        return new ResponseEntity(catalogElementUpdatedStatusDTO,null, HttpStatus.ACCEPTED);
    }
    @Operation(
            description = "Get endpoint for catalog elements",
            summary = "List of catalog element",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }

    )
    @GetMapping
    public ResponseEntity<?> retrievecatalogElement() {
        return new ResponseEntity(catalogElementService.getAllCatalogElements(),null, HttpStatus.OK);
    }

}
