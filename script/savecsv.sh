#!/bin/bash
cp ~/TA/kafka/out/artifacts/kafka_consumer_jar/kafka.jar kafka_consumer.jar
# java -cp [jarfile] DataConsumer [address] [broker port] [topic name] [max read] [file name]
java -cp kafka_consumer.jar DataConsumer localhost 9092 part 1000000 parts.csv