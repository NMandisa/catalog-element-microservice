package za.co.rain.promotion.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import za.co.rain.promotion.catalog.domain.CatalogElement;
import za.co.rain.promotion.catalog.domain.LifecycleStatus;
import za.co.rain.promotion.catalog.facade.impl.DefaultCatalogElementFacade;

@SpringBootApplication
public class PromotionCatalogApplication {

	private static final Logger LOGGER  = LoggerFactory.getLogger(PromotionCatalogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PromotionCatalogApplication.class, args);

		/*DefaultCatalogElementFacade defaultCatalogElementFacade = new DefaultCatalogElementFacade();
		CatalogElement catalogElement = new CatalogElement(LifecycleStatus.IN_DESIGN);
		defaultCatalogElementFacade.validateAndUpdateStatus(catalogElement,LifecycleStatus.ACTIVE);*/



	}

}
