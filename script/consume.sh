#!/bin/bash
# rsync using variables

KAFKADIR=~/Downloads/kafka-0.8.2.2

echo "Please input topic"
read topic

$KAFKADIR/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic $topic --from-beginning
