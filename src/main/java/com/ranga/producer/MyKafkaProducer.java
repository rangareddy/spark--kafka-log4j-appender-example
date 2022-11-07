package com.ranga.producer;

import com.ranga.util.AppConfig;
import com.ranga.util.PropertyUtil;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Date;
import java.util.Properties;

public class MyKafkaProducer {

    private static final Logger logger = Logger.getLogger("kafkaLogger");

    public static void createTopic(String bootstrapServer, String topicName) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServer);
        Admin admin = Admin.create(properties);
        try {
            if (!admin.listTopics().names().get().contains(topicName)) {
                admin.createTopics(Collections.singleton(new NewTopic(topicName, 1, (short) 1))).all().get();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Properties properties = PropertyUtil.getProperties();
        AppConfig appConfig = new AppConfig(properties);
        Producer<String, String> producer = getProducer(appConfig.getBootstrapServers());
        String message = new Date() + "Hello World!";
        ProducerRecord<String, String> record = new ProducerRecord<>(appConfig.getTopicName(), message);
        producer.send(record);
        logger.info("Message sent to kafka successfully");
        producer.close();
    }

    public static Producer<String, String> getProducer(String bootstrapServers) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }
}