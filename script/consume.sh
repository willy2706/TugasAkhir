#!/bin/bash
# rsync using variables

KAFKADIR=~/Downloads/kafka-0.8.2.2

echo "Please input topic"
read topic

$KAFKADIR/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic $topic --from-beginning


# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic part --from-beginning
# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic supplier --from-beginning
# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic partsupp --from-beginning
# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic lineitem --from-beginning
# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic orders --from-beginning
# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic customer --from-beginning
# bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic nation --from-beginning
# $KAFKADIR/bin/kafka-console-consumer.sh --zookeeper 167.205.35.25:2181 --topic region --from-beginning