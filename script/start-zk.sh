#!/bin/bash
# rsync using variables

KAFKADIR=~/Downloads/kafka-0.8.2.2

$KAFKADIR/bin/zookeeper-server-start.sh $KAFKADIR/config/zookeeper.properties
# $KAFKADIR/bin/kafka-server-start.sh $KAFKADIR/config/server.properties
