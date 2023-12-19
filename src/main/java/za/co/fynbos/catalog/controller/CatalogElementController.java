package za.co.fynbos.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.fynbos.catalog.dto.CatalogElementUpdatedStatusDTO;
import za.co.fynbos.catalog.exception.CatalogElementNotFoundException;
import za.co.fynbos.catalog.service.CatalogElementService;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;
import java.util.List;

@CrossOrigin(allowedHeaders = {"*"}, origins = "*")
@RestController
@RequestMapping("/catalog-elements")
public class CatalogElementController {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CatalogElementController.class.getName());
    private CatalogElementService catalogElementService;
    @Autowired //Constructor Autowiring Dependency Injection
    public CatalogElementController(@Qualifier("defaultCatalogElementService") CatalogElementService catalogElementService){
        this.catalogElementService = catalogElementService;
    }
    @PatchMapping(value = "/{id}/status", headers = "Accept=application/json")
    public ResponseEntity<List<CatalogElement>> updateStatus(@PathVariable Long id, @RequestBody LifecycleStatus newStatus) {
        CatalogElement catalogElement = catalogElementService.getCatalogElementById(id);
        if(catalogElement==null) throw new CatalogElementNotFoundException("id :"+id);
        LifecycleStatus OldlifecycleStatus = catalogElement.getStatus();
        catalogElementService.validateAndUpdateStatus(catalogElement, newStatus);
        CatalogElementUpdatedStatusDTO catalogElementUpdatedStatusDTO =
                new CatalogElementUpdatedStatusDTO(catalogElement,OldlifecycleStatus,newStatus); // return informative response
        return new ResponseEntity(catalogElementUpdatedStatusDTO,null, HttpStatus.ACCEPTED);
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CatalogElement>> retrievecatalogElement() {
        return new ResponseEntity(catalogElementService.getAllCatalogElements(),null, HttpStatus.OK);
    }

}
