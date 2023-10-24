package za.co.rain.promotion.catalog.service;

import za.co.rain.promotion.catalog.domain.CatalogElement;
import za.co.rain.promotion.catalog.enums.LifecycleStatus;

import java.util.List;

public interface CatalogElementService {
    void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus);

    CatalogElement getCatalogElementById(Long id);
    List <CatalogElement> getAllCatalogElements();

}
