package za.co.fynbos.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.fynbos.catalog.CatalogApplication;
import za.co.fynbos.catalog.service.impl.DefaultCatalogElementService;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;

import java.util.List;

@CrossOrigin(allowedHeaders = {"*"}, origins = "*")
@RestController
@RequestMapping("/catalog-element")
public class CatalogElementController {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CatalogApplication.class);

    @Autowired
    private DefaultCatalogElementService defaultCatalogElementService;

    @PatchMapping(value = "/{id}/status", headers = "Accept=application/jsom")
    public void updateStatus(@PathVariable Long id, @RequestBody LifecycleStatus newStatus) {
        //Retrieve the CatalogElement from database (this part is not implemented in this example)
        CatalogElement catalogElement = defaultCatalogElementService.getCatalogElementById(id);
        //Validate and update the status
        defaultCatalogElementService.validateAndUpdateStatus(catalogElement, newStatus);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CatalogElement> retrievecatalogElement() {
        return defaultCatalogElementService.getAllCatalogElements();
    }

}
