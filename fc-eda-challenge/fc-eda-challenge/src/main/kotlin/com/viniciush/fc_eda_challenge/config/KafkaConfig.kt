package com.viniciush.fc_eda_challenge.config

import com.viniciush.fc_eda_challenge.balance.events.BalanceUpdatedDto
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer

@Configuration
open class KafkaConfig {
    @Bean
    open fun balanceConsumerFactory(): DefaultKafkaConsumerFactory<String, BalanceUpdatedDto> {
        val props = mutableMapOf<String, Any>()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "kafka:29092"
        props[ConsumerConfig.GROUP_ID_CONFIG] = "balance-group"
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = ErrorHandlingDeserializer::class.java

        val jsonDeserializer = JacksonJsonDeserializer(BalanceUpdatedDto::class.java)
        jsonDeserializer.addTrustedPackages("*")

        return DefaultKafkaConsumerFactory(
            props,
            StringDeserializer(),
            ErrorHandlingDeserializer(jsonDeserializer),
        )
    }

    @Bean
    open fun balanceKafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, BalanceUpdatedDto> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, BalanceUpdatedDto>()
        factory.setConsumerFactory(balanceConsumerFactory())
        return factory
    }
}
