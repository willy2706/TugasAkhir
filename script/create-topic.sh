KAFKADIR=~/Downloads/kafka-0.8.2.2

echo "Please input topic you want to create"
read topic

$KAFKADIR/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic $topic