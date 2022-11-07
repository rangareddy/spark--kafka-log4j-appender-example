# Kafka Log4j Appender Example

Step1: Download the project

```sh
git clone https://github.com/rangareddy/spark-kafka-log4j-appender-example.git
cd /root/spark-kafka-log4j-appender-example
```

Step2: Update the topicName and bootstrapServers in `src/main/resources/log4j.properties `

```sh
log4j.appender.KAFKA.brokerList=node1:9092,node2:9092
log4j.appender.KAFKA.topic=spark_kafka_log4j_topic
```

> In log4j.properties, don't add KAFKA appender to rootLoger. It will throw the **org.apache.kafka.common.errors.TimeoutException: Topic spark_kafka_log4j_topic not present in metadata after 60000 ms** error.

Step3: Build the project

```sh
mvn clean package
```

Step4: Run the following code to test

```sh
java -jar target/spark-kafka-log4j-appender-example-1.0.0-SNAPSHOT.jar com.ranga.SparkKafkaLog4jAppenderApp
```

**Producer Example**

> Before running producer example, update the bootstrapServers value
> 
```sh
java -jar target/spark-kafka-log4j-appender-example-1.0.0-SNAPSHOT.jar com.ranga.producer.MyKafkaProducer
```

**Consumer Example** - 

> Before running consumer example, update the bootstrapServers value

```sh
java -jar target/spark-kafka-log4j-appender-example-1.0.0-SNAPSHOT.jar com.ranga.consumer.MyKafkaConsumer
```

## Kafka Commands

```sh
$ kafka-topics --create --bootstrap-server `hostname -f`:9092 --replication-factor 1 --partitions 3 --topic spark_kafka_log4j_topic
$ kafka-topics --list --bootstrap-server `hostname -f`:9092
$ kafka-console-producer --broker-list `hostname -f`:9092 --topic spark_kafka_log4j_topic
$ kafka-console-consumer --bootstrap-server `hostname -f`:9092 --topic spark_kafka_log4j_topic --from-beginning 
```
