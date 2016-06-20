import helper.Helper;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import model.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
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
        Helper.MAX_ROW = 1000000;
        config = new ProducerConfig(producerProperties);
        producer = new Producer<>(config);
    }
    public static void main(String[] args) throws IOException {
        System.out.println("How to use: java DataProducer [address] [broker port] [min id] [max id] [topic name] [type] [max row]");
        System.out.println("Example : java -cp kafka_producer.jar DataProducer localhost 9092 1 1000000 part 1 1000000");
        String address = args[0];
        int port = Integer.parseInt(args[1]);
        int minId = Integer.parseInt(args[2]);
        int maxId = Integer.parseInt(args[3]);
        String topicName = args[4];
        int type = Integer.parseInt(args[5]);
        Helper.MAX_ROW = Integer.parseInt(args[6]);

//        String address = "localhost";
//        int port = 9092;
//        int minId = 1;
//        int maxId = 10;
//        String topicName = "part";
//        int type = 1;
//        Helper.MAX_ROW = 1000000;

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
                case 2:
                    modelInterface = new Supplier(i);
                    break;
                case 3:
                    modelInterface = new Partsupp();
                    break;
                case 4:
                    modelInterface = new Lineitem();
                    break;
                case 5:
                    modelInterface = new Orders(i);
                    break;
                case 6:
                    modelInterface = new Customer(i);
                    break;
                case 7:
                    modelInterface = new Nation(i);
                    break;
                case 8:
                    modelInterface = new Region(i);
                    break;
            }
//            String serializedObject = mapper.writeValueAsString(modelInterface);
            String serializedObject = convert(modelInterface);
            KeyedMessage<String, String> data = new KeyedMessage<>(this.topicName,"1",serializedObject);
            producer.send(data);
        }
        producer.close();
    }

    private String convert (ModelInterface modelInterface) {
        String CSV_SEPARATOR = ",";
        StringBuilder ret = new StringBuilder();
        for (Field field : modelInterface.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(modelInterface);
                ret.append(value);
                ret.append(CSV_SEPARATOR);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        ret.deleteCharAt(ret.length()-1); //buang csv separator
        return ret.toString();
    }

}
