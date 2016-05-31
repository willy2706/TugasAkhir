#!/bin/bash
# rsync using variables

KAFKADIR=~/Downloads/kafka-0.8.2.2

$KAFKADIR/bin/kafka-topics.sh --list --zookeeper localhost:2181
