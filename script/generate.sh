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

# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 1700000 part 1 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 1700000 supplier 2 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 1700000 partsupp 3 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 1700000 lineitem 4 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 1700000 orders 5 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 1700000 customer 6 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 25 nation 7 1700000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5 region 8 1700000

# java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 lineitem 4 1000000

# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5100000 part 1 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5100000 supplier 2 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5100000 partsupp 3 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5100000 lineitem 4 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5100000 orders 5 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5100000 customer 6 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 25 nation 7 5100000
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5 region 8 5100000


# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 50 part 1 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 50 supplier 2 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 50 partsupp 3 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 50 lineitem 4 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 50 orders 5 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 50 customer 6 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 25 nation 7 50
# java -cp kafka_producer.jar DataProducer 167.205.35.25 9092 1 5 region 8 50