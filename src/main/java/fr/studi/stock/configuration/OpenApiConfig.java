package fr.studi.stock.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// SWAGGER

// bean : "EJB"
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Stock API")
                .description("Projet fait pour le Bachelor Java")
                        .version("1.0")
                        .license(new License().name("My Licence")));
    }
}
