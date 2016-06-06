#!/bin/bash
cp ~/TA/kafka/out/artifacts/kafka_producer_jar/kafka.jar kafka_producer.jar
# java -cp [jarfile] DataProducer [address] [broker port] [min id] [max id] [topic name] [type] [max row]
echo "Generating part"
java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 part 1 1000000
echo "Generating supplier"
java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 supplier 2 1000000
echo "Generating partsupp"
java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 partsupp 3 1000000
echo "Generating lineitem"
java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 lineitem 4 1000000
echo "Generating orders"
java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 orders 5 1000000
echo "Generating customer"
java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 customer 6 1000000
echo "Generating region"
java -cp kafka_producer.jar DataProducer localhost 9092 1 100 region 7 1000000
echo "Generating nation"
java -cp kafka_producer.jar DataProducer localhost 9092 1 10 nation 8 1000000