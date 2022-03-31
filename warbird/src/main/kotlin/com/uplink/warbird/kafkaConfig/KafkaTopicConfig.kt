package com.uplink.warbird.kafkaConfig

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    @Bean
    public fun createTopic(topic: String): NewTopic{
        return TopicBuilder.name(topic)
            .build()
    }
}