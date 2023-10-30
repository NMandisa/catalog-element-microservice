package za.co.fynbos.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@SpringBootApplication
public class CatalogApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);

		/*DefaultCatalogElementFacade defaultCatalogElementFacade = new DefaultCatalogElementFacade();
		CatalogElement catalogElement = new CatalogElement(LifecycleStatus.IN_DESIGN);
		defaultCatalogElementFacade.validateAndUpdateStatus(catalogElement,LifecycleStatus.ACTIVE);*/


    }

}
