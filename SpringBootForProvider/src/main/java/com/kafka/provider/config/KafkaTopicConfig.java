package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){
        Map<String, String> topicConfigs = new HashMap<>();
        topicConfigs.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        topicConfigs.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
        topicConfigs.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        topicConfigs.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "100000");

        return TopicBuilder.name("kafka-Topic")
                .partitions(2)
                .replicas(2)
                .configs(topicConfigs)
                .build();
    }
}
