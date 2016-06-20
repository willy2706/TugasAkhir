#!/bin/bash
cp ~/TA/kafka/out/artifacts/kafka_producer_jar/kafka.jar kafka_producer.jar
# java -cp [jarfile] DataProducer [address] [broker port] [min id] [max id] [topic name] [type] [max row]
echo "Generating part"
java -cp kafka_producer.jar DataProducer localhost 9092 1 2200000 part 1 2200000
echo "Generating supplier"
java -cp kafka_producer.jar DataProducer localhost 9092 1 2200000 supplier 2 2200000
echo "Generating partsupp"
java -cp kafka_producer.jar DataProducer localhost 9092 1 2200000 partsupp 3 2200000
echo "Generating lineitem"
java -cp kafka_producer.jar DataProducer localhost 9092 1 2200000 lineitem 4 2200000
echo "Generating orders"
java -cp kafka_producer.jar DataProducer localhost 9092 1 2200000 orders 5 2200000
echo "Generating customer"
java -cp kafka_producer.jar DataProducer localhost 9092 1 2200000 customer 6 2200000
echo "Generating nation"
java -cp kafka_producer.jar DataProducer localhost 9092 1 25 nation 7 2200000
echo "Generating region"
java -cp kafka_producer.jar DataProducer localhost 9092 1 5 region 8 2200000