package io.meighen.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class RoutesConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("presenter_route",
                        route -> route.path("/presenter/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://presenter"))
                .route("guarder_route",
                        route -> route.path("/guarder/**")
                                .filters(filter -> filter.stripPrefix(1)
                                )
                                .uri("lb://guarder"))
                .build();
    }
}