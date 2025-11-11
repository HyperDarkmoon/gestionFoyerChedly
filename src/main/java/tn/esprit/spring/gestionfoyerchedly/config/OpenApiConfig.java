package tn.esprit.spring.gestionfoyerchedly.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion Foyer API",
                version = "v1",
                description = "REST API documentation for the Gestion Foyer application",
                contact = @Contact(name = "HyperDarkmoon", email = "", url = ""),
                license = @License(name = "MIT", url = "https://opensource.org/licenses/MIT")
        )
)
@Configuration
public class OpenApiConfig {
    // Intentionally empty; annotations above configure the OpenAPI document
}
