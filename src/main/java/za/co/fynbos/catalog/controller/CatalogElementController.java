package za.co.fynbos.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import za.co.fynbos.catalog.CatalogApplication;
import za.co.fynbos.catalog.dto.CatalogElementUpdatedStatusDTO;
import za.co.fynbos.catalog.exception.CatalogElementNotFoundException;
import za.co.fynbos.catalog.service.impl.DefaultCatalogElementService;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@CrossOrigin(allowedHeaders = {"*"}, origins = "*")
@RestController
@RequestMapping("/catalog-elements")
public class CatalogElementController {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CatalogApplication.class);

    @Autowired
    private DefaultCatalogElementService defaultCatalogElementService;

    public CatalogElementController(DefaultCatalogElementService catalogElementService){
        this.defaultCatalogElementService = catalogElementService;
    }

    @PatchMapping(value = "/{id}/status", headers = "Accept=application/json")
    public ResponseEntity<Object> updateStatus(@PathVariable Long id, @RequestBody LifecycleStatus newStatus) {
        CatalogElement catalogElement = defaultCatalogElementService.getCatalogElementById(id);
        if(catalogElement==null) throw new CatalogElementNotFoundException("id :"+id);
        LifecycleStatus OldlifecycleStatus = catalogElement.getStatus();
        defaultCatalogElementService.validateAndUpdateStatus(catalogElement, newStatus);
        CatalogElementUpdatedStatusDTO catalogElementUpdatedStatusDTO =
                new CatalogElementUpdatedStatusDTO(catalogElement,OldlifecycleStatus,newStatus); // return informative response
        return ResponseEntity.ok(catalogElementUpdatedStatusDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CatalogElement> retrievecatalogElement() {
        return defaultCatalogElementService.getAllCatalogElements();
    }

}
