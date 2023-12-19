package za.co.fynbos.catalog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;
import za.co.fynbos.catalog.facade.CatalogElementFacade;
import za.co.fynbos.catalog.service.CatalogElementService;

import java.util.List;

@Service
public class DefaultCatalogElementService implements CatalogElementService {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CatalogElementService.class);
    private CatalogElementFacade catalogElementFacade;
    @Autowired //Setter Dependency Injection
    private CatalogElementFacade setCatalogElementFacade(@Qualifier("defaultCatalogElementFacade") CatalogElementFacade catalogElementFacade){
        return this.catalogElementFacade = catalogElementFacade;
    }
    @Override
    public void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus) {
        catalogElementFacade.validateAndUpdateStatus(catalogElement,newStatus);
    }

    @Override
    public CatalogElement getCatalogElementById(Long id) {
        return catalogElementFacade.findCatalogElementById(id);
    }

    @Override
    public List<CatalogElement> getAllCatalogElements() {
        return catalogElementFacade.findall();
    }


}
