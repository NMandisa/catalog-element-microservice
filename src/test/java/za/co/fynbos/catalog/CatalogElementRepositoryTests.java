package za.co.fynbos.catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.enums.LifecycleStatus;
import za.co.fynbos.catalog.repository.CatalogElementRepository;

import java.util.List;

/**
 * @author Noxolo.Mkhungo
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CatalogElementRepositoryTests {
    @Autowired
    CatalogElementRepository catalogElementRepository;
    @BeforeEach
    void cleanup() {
        catalogElementRepository.deleteAll();
    }
    @Test
    public void testFindAllCatalogElement() {
       CatalogElement catalogElement = new CatalogElement(LifecycleStatus.IN_DESIGN);
        CatalogElement catalogElement2 = new CatalogElement(LifecycleStatus.IN_TEST);
        CatalogElement catalogElemen3 = new CatalogElement(LifecycleStatus.IN_STUDY);
        CatalogElement catalogElement4 = new CatalogElement(LifecycleStatus.REJECTED);
        CatalogElement catalogElement5 = new CatalogElement(LifecycleStatus.RETIRED);
        CatalogElement catalogElement6 = new CatalogElement(LifecycleStatus.OBSOLETE);
        CatalogElement catalogElement7 = new CatalogElement(LifecycleStatus.LAUNCHED);
        CatalogElement catalogElement8 = new CatalogElement(LifecycleStatus.IN_DESIGN);
        CatalogElement catalogElement9 = new CatalogElement(LifecycleStatus.IN_STUDY);
        CatalogElement catalogElement10 = new CatalogElement(LifecycleStatus.IN_STUDY);
        CatalogElement catalogElement11 = new CatalogElement(LifecycleStatus.IN_STUDY);
        CatalogElement catalogElement12 = new CatalogElement(LifecycleStatus.IN_DESIGN);
        CatalogElement catalogElement13 = new CatalogElement(LifecycleStatus.REJECTED);
        CatalogElement catalogElement14 = new CatalogElement(LifecycleStatus.IN_DESIGN);


        catalogElementRepository.saveAll(List.of(catalogElement,catalogElement2,catalogElemen3,catalogElement4,
                catalogElement5,catalogElement6,catalogElement7,catalogElement8,catalogElement9,catalogElement10,
                catalogElement11,catalogElement12,catalogElement13,catalogElement14));
        List<CatalogElement> result = catalogElementRepository.findAll();
        Assertions.assertEquals(14, result.size());
    }

}
