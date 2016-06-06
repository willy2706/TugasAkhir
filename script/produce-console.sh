KAFKADIR=~/Downloads/kafka-0.8.2.2

echo "Please input topic you want to produce"
read topic

$KAFKADIR/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic $topic