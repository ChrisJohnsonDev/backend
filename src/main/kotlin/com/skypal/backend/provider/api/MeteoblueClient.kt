package com.skypal.backend.provider.api

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient


class MeteoblueClient {

    private val webClient: WebClient = WebClient.builder()
        .baseUrl("https://my.meteoblue.com")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build()

    fun fetchWeatherData(): String? {
        return webClient.get()
            .uri { builder ->
                builder
                    .path("/packages/basic-1h_basic-day")
                    .queryParam("lat", "47.558")
                    .queryParam("lon", "7.573")
                    .queryParam("apikey", "MU7kt3PRwJ0FKinB")
                    .build()
            }
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
    }
}

