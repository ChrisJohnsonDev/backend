package com.skypal.backend

import com.skypal.backend.provider.api.MeteoblueClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
	val test = MeteoblueClient()
	val testResponse = test.fetchWeatherData()
	print(testResponse)
}
