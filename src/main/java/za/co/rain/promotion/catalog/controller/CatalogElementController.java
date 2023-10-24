package za.co.rain.promotion.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.*;
import za.co.rain.promotion.catalog.PromotionCatalogApplication;
import za.co.rain.promotion.catalog.domain.CatalogElement;
import za.co.rain.promotion.catalog.enums.LifecycleStatus;
import za.co.rain.promotion.catalog.service.impl.DefaultCatalogElementService;

import java.util.List;

@CrossOrigin(allowedHeaders = {"*"}, origins = "*")
@RestController
@RequestMapping("/catalog-element")
public class CatalogElementController {
    private static final Logger LOGGER  = LoggerFactory.getLogger(PromotionCatalogApplication.class);

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
