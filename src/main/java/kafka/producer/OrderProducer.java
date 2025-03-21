package kafka.producer;

import kafka.model.Order;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import com.google.gson.Gson;

import java.util.Properties;
import java.util.UUID;

public class OrderProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(props)) {
            Gson gson = new Gson();
            for (int i = 0; i < 5; i++) {
                Order order = new Order(UUID.randomUUID().toString(), "Product-" + i, (i + 1) * 10);
                ProducerRecord<String, String> record = new ProducerRecord<>("orders", order.orderId, gson.toJson(order));
                producer.send(record);
                System.out.println("Sent: " + order);
            }
        }
    }
}