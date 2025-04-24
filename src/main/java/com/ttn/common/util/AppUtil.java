package com.ttn.common.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AppUtil {
    
    private final WebClient webClient;
    
    public AppUtil(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    
    /**
     * Makes a GET request to the specified URL
     * @param url The URL to make the request to
     * @param responseType The expected response type class
     * @return Mono of the response type
     */
    public <T> Mono<T> get(String url, Class<T> responseType) {
        return webClient.get()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(responseType);
    }
    
    /**
     * Makes a POST request to the specified URL with the given body
     * @param url The URL to make the request to
     * @param body The request body
     * @param responseType The expected response type class
     * @return Mono of the response type
     */
    public <T, R> Mono<R> post(String url, T body, Class<R> responseType) {
        return webClient.post()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }
    
    /**
     * Makes a PUT request to the specified URL with the given body
     * @param url The URL to make the request to
     * @param body The request body
     * @param responseType The expected response type class
     * @return Mono of the response type
     */
    public <T, R> Mono<R> put(String url, T body, Class<R> responseType) {
        return webClient.put()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }
    
    /**
     * Makes a DELETE request to the specified URL
     * @param url The URL to make the request to
     * @return Mono<Void>
     */
    public Mono<Void> delete(String url) {
        return webClient.delete()
                .uri(url)
                .retrieve()
                .bodyToMono(Void.class);
    }
} 