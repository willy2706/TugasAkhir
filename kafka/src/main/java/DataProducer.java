import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import model.ModelInterface;
import model.Part;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by nim_13512065 on 5/31/16.
 */
public class DataProducer {
    private final ObjectMapper mapper;
    private final ProducerConfig config;
    private final Producer<String, String> producer;
    private final int min_id;
    private final int max_id;
    private final String topicName;
    private ConsumerConfig consumerConfig;
    private final int type;

    public DataProducer(String address, int port, int min_id, int max_id, String topicName, int type) {
        mapper = new ObjectMapper();

        this.min_id = min_id;
        this.max_id = max_id;
        this.topicName = topicName;
        this.type = type;

        String fullAddress = address + ":" + port;
        Properties producerProperties = new Properties();
        producerProperties.put("metadata.broker.list", fullAddress);
        producerProperties.put("serializer.class", "kafka.serializer.StringEncoder");
//        props.put("partitioner.class", "SimplePartitioner");
        producerProperties.put("request.required.acks", "1");

        config = new ProducerConfig(producerProperties);
        producer = new Producer<>(config);
    }
    public static void main(String[] args) throws IOException {
        System.out.println("How to use: java DataProducer [address] [broker port] [min id] [max id] [topic name] [type]");
        System.out.println("Example : java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 part 1");
        String address = args[0];
        int port = Integer.parseInt(args[1]);
        int minId = Integer.parseInt(args[2]);
        int maxId = Integer.parseInt(args[3]);
        String topicName = args[4];
        int type = Integer.parseInt(args[5]);

//        String address = "localhost";
//        int port = 9092;
//        int minId = 1;
//        int maxId = 10;
//        String topicName = "part";
//        int type = 1;

        DataProducer dataProducer = new DataProducer(address, port, minId, maxId, topicName, type);
        dataProducer.runProducer();
    }
    public void runProducer() throws IOException {
        for (int i = min_id; i <= max_id; ++i) {
            ModelInterface modelInterface = null;
            switch (type) {
                case 1:
                    modelInterface = new Part(i);
                    break;
            }
            String serializedObject = mapper.writeValueAsString(modelInterface);
            KeyedMessage<String, String> data = new KeyedMessage<>(this.topicName,"1",serializedObject);
            producer.send(data);
        }
        producer.close();
    }

    public void runConsumer() {
        Properties props1 = new Properties();
        props1.put("zookeeper.connect", "localhost:2181");
        props1.put("group.id", "default");
        props1.put("zookeeper.session.timeout.ms", "10000");
        props1.put("zookeeper.sync.time.ms", "200");
        props1.put("auto.commit.interval.ms", "1000");
        props1.put("auto.offset.reset", "smallest");
        consumerConfig = new ConsumerConfig(props1);

        kafka.api.OffsetRequest.EarliestTime();

        ConsumerConnector consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put("part", 1);

        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);

        List<KafkaStream<byte[], byte[]>> streamList = consumerMap.get("part");

        KafkaStream stream = streamList.get(0);

        ConsumerIterator<byte[], byte[]> iterator = stream.iterator();
        while(iterator.hasNext()) {
            System.out.println(new String(iterator.next().message()));
        }
    }
}
