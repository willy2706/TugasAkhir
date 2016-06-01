#!/bin/bash
cp ~/TA/kafka/out/artifacts/kafka_producer_jar/kafka.jar kafka_producer.jar
# java -cp [jarfile] DataProducer [address] [broker port] [min id] [max id] [topic name] [type]
java -cp kafka_producer.jar DataProducer localhost 9092 11 1000000 part 1