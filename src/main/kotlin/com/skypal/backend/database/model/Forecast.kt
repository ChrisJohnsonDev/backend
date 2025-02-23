package com.skypal.backend.database.model

import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class Forecast(
    @get:DynamoDbPartitionKey
    @field:NotNull
    var locationId: String? = "",

    @get:DynamoDbSortKey
    @field:NotNull
    var forecastTime: String? = "",

    @field:NotBlank
    var temperature: Double? = null,
    @field:NotBlank
    var humidity: Int? = null,
    @field:NotBlank
    var pressure: Double? = null,
    @field:NotBlank
    var windSpeed: Double? = null,
    @field:NotBlank
    var windDirection: String? = null,
    @field:NotBlank
    var precipitation: Double? = null,
    @field:NotBlank
    var precipitationProbability: Int?,
    @field:NotBlank
    var iconCode: String? = null,
    @field:NotBlank
    var recordedAt: String? = null,
)
