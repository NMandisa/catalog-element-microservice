package za.co.fynbos.catalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.domain.enums.LifecycleStatus;

import java.util.List;

@Repository
public interface CatalogElementRepository extends CrudRepository <CatalogElement,Long> {
    @Override
    List<CatalogElement> findAll();

    CatalogElement findCatalogElementByStatus(LifecycleStatus status);
    CatalogElement findCatalogElementById(Long id);
}
