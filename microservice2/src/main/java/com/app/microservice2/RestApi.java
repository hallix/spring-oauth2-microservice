package com.app.microservice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@RestController
public class RestApi {
    private final WebClient webClient;

   public RestApi(WebClient webClient){
       this.webClient = webClient;
   }

    @GetMapping("/service/two")
    public String[] hello(){
        return webClient
                .get()
                .uri("http://localhost:8083/service/one")
                .attributes(clientRegistrationId("articles-client"))
                .retrieve()
                .bodyToMono(String[].class)
                .block();
    }
}
