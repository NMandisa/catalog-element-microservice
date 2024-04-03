package za.co.fynbos.catalog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author Noxolo.Mkhungo
 */

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Noxolo Mkhungo",
                        email = "noxolomandisamkhungo@gmail.com",
                        url = ""
                ),
                description = "OpenApi documentation Catalog Element Microservice",
                title = "OpenApi specification - Catalog Element Microservice",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        })
public class OpenApiConfig {
}
