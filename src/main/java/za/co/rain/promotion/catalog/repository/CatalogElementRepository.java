package za.co.rain.promotion.catalog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.co.rain.promotion.catalog.domain.CatalogElement;
import za.co.rain.promotion.catalog.domain.LifecycleStatus;

import java.util.List;

@Repository
@Transactional
public interface CatalogElementRepository extends CrudRepository <CatalogElement,Long> {
    @Override
    List<CatalogElement> findAll();

    CatalogElement findCatalogElementByStatus(LifecycleStatus status);
    CatalogElement findCatalogElementById(Long id);
}
