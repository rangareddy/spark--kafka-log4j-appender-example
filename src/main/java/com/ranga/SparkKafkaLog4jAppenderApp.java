package com.ranga;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

public class SparkKafkaLog4jAppenderApp {

    private static final Logger logger = Logger.getLogger("kafkaLogger");

    public static void main(String[] args) {

        // Creating the SparkConf object
        SparkConf sparkConf = new SparkConf().setAppName("Spark Kafka Log4j Appender App").setIfMissing("spark.master", "local[2]");

        // Creating the SparkSession object
        SparkSession spark = SparkSession.builder().config(sparkConf).getOrCreate();
        logger.info("SparkSession created successfully");

        long count = spark.range(1, 101).count();
        logger.info("Spark count value : " + count);

        // Close the SparkSession
        spark.close();
        logger.info("SparkSession closed successfully");
    }
}
