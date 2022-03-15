package com.example.warbird.kafkaConfig

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    @Bean
    public fun createTopic(): NewTopic{
        return TopicBuilder.name("vulcan")
            .build()
    }
}