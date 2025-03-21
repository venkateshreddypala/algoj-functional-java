package springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"springboot.kafka.api", "kafka.model"})
public class KafkaRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaRestApplication.class, args);
    }
}