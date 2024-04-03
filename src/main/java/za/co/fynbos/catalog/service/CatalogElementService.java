package za.co.fynbos.catalog.service;

import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.domain.enums.LifecycleStatus;

import java.util.List;

public interface CatalogElementService {
    void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus);

    CatalogElement getCatalogElementById(Long id);
    List <CatalogElement> getAllCatalogElements();

}
