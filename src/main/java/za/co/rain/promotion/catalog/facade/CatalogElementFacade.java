package za.co.rain.promotion.catalog.facade;

import za.co.rain.promotion.catalog.domain.CatalogElement;
import za.co.rain.promotion.catalog.enums.LifecycleStatus;

import java.util.List;

public interface CatalogElementFacade {

    void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus);
    void validateTransition(LifecycleStatus currentStatus, LifecycleStatus newStatus);

    CatalogElement findCatalogElementById(Long id);
    List<CatalogElement> findall();
}
