package com.webflux.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class Router {
    
    @Bean
    public RouterFunction<ServerResponse> route(WebFluxRestController controller) {
  
      return RouterFunctions
        .route(GET("/serverResponseFromRouter"), controller::getServerResponse);
    }

}
