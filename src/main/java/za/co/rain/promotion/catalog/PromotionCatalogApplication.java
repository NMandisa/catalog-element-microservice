package za.co.rain.promotion.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
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
