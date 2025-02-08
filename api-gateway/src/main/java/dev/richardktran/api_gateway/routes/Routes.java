package dev.richardktran.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user_service", r -> r
                        .path("/api/v1/users/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("userServiceCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://user-service"))

                .route("id_generation_service", r -> r
                        .path("/api/v1/id-generation/**")
                        .filters(f -> f.circuitBreaker(config -> config.setName("idGenerationServiceCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://id-generation-service"))

                .route("fallback_route", r -> r
                        .path("/fallbackRoute")
                        .uri("forward:/fallbackRoute"))
                .build();
    }
}
