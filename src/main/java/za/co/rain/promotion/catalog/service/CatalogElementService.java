package za.co.rain.promotion.catalog.service;

import za.co.rain.promotion.catalog.domain.CatalogElement;
import za.co.rain.promotion.catalog.domain.LifecycleStatus;

public interface CatalogElementService {
    void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus);

    CatalogElement getCatalogElementById(Long id);

}
