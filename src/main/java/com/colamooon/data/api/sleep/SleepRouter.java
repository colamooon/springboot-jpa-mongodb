package com.colamooon.data.api.sleep;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class SleepRouter {

    @Bean
    public RouterFunction<ServerResponse> sleepRouterFunction(SleepHandler handler) {

        return RouterFunctions
                .nest(path("/api/v1/sleep"),
                        route(POST("/today/sleeps").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), handler::postSleeps)
                                .andRoute(GET("/find/lastest").and(accept(APPLICATION_JSON)), handler::getLastestOne)
                );
    }
}
