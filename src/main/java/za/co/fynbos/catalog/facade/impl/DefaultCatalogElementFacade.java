package za.co.fynbos.catalog.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import za.co.fynbos.catalog.facade.CatalogElementFacade;
import za.co.fynbos.catalog.repository.CatalogElementRepository;
import za.co.fynbos.catalog.domain.CatalogElement;
import za.co.fynbos.catalog.domain.enums.LifecycleStatus;

import java.util.List;

@Component
@Scope("singleton")
public class DefaultCatalogElementFacade implements CatalogElementFacade {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CatalogElementFacade.class.getName());
    private boolean isValidtransition;
    @Autowired
    private CatalogElementRepository catalogElementRepository;
    @Override
    public void validateAndUpdateStatus(CatalogElement catalogElement, LifecycleStatus newStatus) {
        // Validate the transition
        validateTransition(catalogElement.getStatus(), newStatus);
        if (isValidtransition){
            // Update the status
            catalogElement.setStatus(newStatus);
            // Save the updated entity...
            catalogElementRepository.save(catalogElement);
        }
    }

    @Override
    public void validateTransition(LifecycleStatus currentStatus, LifecycleStatus newStatus) {
        // Implement transition validation logic here..
        if(currentStatus.equals(newStatus))//Check current LifeCycleStatus is not the same as New LifeCycleStatus
        {isValidtransition=false;
            LOGGER.info("Current LifeCycleStatus is the same as New Status",DefaultCatalogElementFacade.class);
        }
        else if (newStatus.equals(currentStatus))//Check New LifeCycleStatus is not the same as current LifeCycleStatus
        {isValidtransition=false;
            LOGGER.info("Transition invalid : New LifeCycleStatus is the same as Current LifeCycleStatus",DefaultCatalogElementFacade.class);}
        else if (currentStatus.equals(newStatus) || newStatus.equals(currentStatus))//validating that not one of the condition is being met(might seem redundant
        {isValidtransition=false;
            LOGGER.info("Transition invalid : Current LifeCycleStatus or New LifeCycle Status shouldn't be he same",DefaultCatalogElementFacade.class);
        }
        else if (!currentStatus.equals(newStatus) && !newStatus.equals(currentStatus))//checking if niether are the same and if that condition is met that the transition is valid
        {isValidtransition=true;
            LOGGER.info("Transition valid: Current LifeCycleStatus and New LifeCycleStatus are not the same ",DefaultCatalogElementFacade.class);
        }

    }

    @Override
    public CatalogElement findCatalogElementById(Long id) {
        return catalogElementRepository.findCatalogElementById(id);
    }

    @Override
    public List<CatalogElement> findall() {
        return catalogElementRepository.findAll();
    }


}
