package com.skypal.backend.database.bootstrap

import com.skypal.backend.database.model.Forecast
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Component
class DynamoDbBootstrap(private val dynamoDbClient: DynamoDbClient): CommandLineRunner {

    override fun run(vararg args: String?) {
        val enhancedClient = DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()

        val forecastTable: DynamoDbTable<Forecast> = enhancedClient.table("Forecast", TableSchema.fromBean(Forecast::class.java))

        try {
            forecastTable.createTable()
            println("Table: Forecast successfully created")
        } catch(e: Exception) {
            println("Table: Forecast may already exist or an error has occurred: ${e.message}")
        }
    }


}