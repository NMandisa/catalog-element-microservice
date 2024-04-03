package za.co.fynbos.catalog.facade;

import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.domain.enums.LifecycleStatus;

import java.util.List;

public interface CatalogElementFacade {

    void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus);
    void validateTransition(LifecycleStatus currentStatus, LifecycleStatus newStatus);

    CatalogElement findCatalogElementById(Long id);
    List<CatalogElement> findall();
}
