package za.co.fynbos.catalog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;
import za.co.fynbos.catalog.facade.impl.DefaultCatalogElementFacade;
import za.co.fynbos.catalog.service.CatalogElementService;

import java.util.List;

@Service
public class DefaultCatalogElementService implements CatalogElementService {

    private static final Logger LOGGER  = LoggerFactory.getLogger(DefaultCatalogElementService.class);
    @Autowired
    private DefaultCatalogElementFacade defaultCatalogElementFacade;
    @Override
    public void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus) {
        defaultCatalogElementFacade.validateAndUpdateStatus(catalogElement,newStatus);
    }

    @Override
    public CatalogElement getCatalogElementById(Long id) {
        return defaultCatalogElementFacade.findCatalogElementById(id);
    }

    @Override
    public List<CatalogElement> getAllCatalogElements() {
        return defaultCatalogElementFacade.findall();
    }


}
