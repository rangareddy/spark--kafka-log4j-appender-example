package com.ranga;

import java.util.Properties;

public class AppConfig {

    private Properties properties;
    private String bootstrapServers;
    private String topicName;
    private String consumerGroupId = "my_consumer";
    private String autoOffsetResetConfig = "earliest";

    public AppConfig(Properties properties) {
        this.properties = properties;
        bootstrapServers = properties.getProperty("log4j.appender.KAFKA.brokerList");
        topicName = properties.getProperty("log4j.appender.KAFKA.topic");
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public String getAutoOffsetResetConfig() {
        return autoOffsetResetConfig;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "bootstrapServers='" + bootstrapServers + '\'' +
                ", topicName='" + topicName + '\'' +
                ", consumerGroupId='" + consumerGroupId + '\'' +
                ", autoOffsetResetConfig='" + autoOffsetResetConfig + '\'' +
                '}';
    }
}
