package springboot.kafka.api;

import kafka.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public String sendOrder(@RequestBody Order order) {
        order.orderId = UUID.randomUUID().toString();
        kafkaTemplate.send("orders", order.orderId, order.toString());
        return "Order sent: " + order;
    }
}