package com.uplink.warbird.kafkaConfig.producers

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaProducerConfig {

    @Value("spring.kafka.bootstrap-servers")
    val bootStrapServer: String? = null;
    


}