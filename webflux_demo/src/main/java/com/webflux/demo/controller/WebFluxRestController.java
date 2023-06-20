package com.webflux.demo.controller;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
public class WebFluxRestController {
    
    @GetMapping
    public Mono<String> getStringMono(){
        return Mono.just("test");
    }

    @GetMapping("/flux")
    public Flux<String> getStringFlux(){
        return Flux.just("test", "test2", "test3");
    }

    //example of server sent event
    @GetMapping("/serverSentEvent")
    public Flux<String> serverSentEvent(){
        return Flux.interval(Duration.ofSeconds(1))
        .map(sequence -> "Flux - " + LocalTime.now().toString());
    }

    @GetMapping("/serverResponse") //works only from router.. -  Annotated controllers and functional endpoints are two different approaches
    public Mono<ServerResponse> getServerResponse(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
          .body(BodyInserters.fromValue("{}"));
    }
    //you could also replace the ServerRequest argument with ServerHttpRequest, which is supported with the @GetMapping annotation.
    //This does require the use of ResponseEntity as opposed to ServerResponse.
}
