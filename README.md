# Apache-Kafka-POC-3

first run mysqlsimulator to start kafka.producer
and then start taxizone kafka.consumer


Follow this procedure
****************************
1)Make a file with docker-compose.yml
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.0.1
    container_name: zookeeper
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  broker:
    image: confluentinc/cp-kafka:7.0.1
    container_name: broker
    ports:
    # To learn about configuring Kafka for access across networks see
    # https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: 'zookeeper:2181'
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_INTERNAL:PLAINTEXT
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092,PLAINTEXT_INTERNAL://broker:29092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
      KAFKA_TRANSACTION_STATE_LOG_MIN_ISR: 1
      KAFKA_TRANSACTION_STATE_LOG_REPLICATION_FACTOR: 1

2)docker-compose up -d

3)docker ps

4)docker-compose ps

5) docker exec 813e23dded95 kafka-topics --bootstrap-server localhost:9092 --create --topic orders --partitions 1 --replication-factor 1

PS D:\Devopse> docker exec 813e23dded95 kafka-topics --bootstrap-server localhost:9092 --create --topic taxizone-topic --partitions 1 --replication-factor 1
Created topic taxizone-topic.

6)docker exec -it 813e23dded95 kafka-console-producer --bootstrap-server localhost:9092 --topic taxizone-topic

PS D:\Devopse> docker exec -it 813e23dded95 kafka-console-producer --bootstrap-server localhost:9092 --topic taxizone-topic
>hi Naveen
how are you

7) docker exec -it 813e23dded95 kafka-console-consumer --bootstrap-server localhost:9092 --topic taxizone-topic --from-beginning

PS D:\Devopse> docker exec -it 813e23dded95 kafka-console-consumer --bootstrap-server localhost:9092 --topic taxizone-topic --from-beginning
hi Naveen
how are you
