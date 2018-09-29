package pl.messageBroker.messageBrokerReciver;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;
import pl.messageBroker.service.QuotationService;

import java.io.IOException;

@Component
public class QuotationReciverRabbitMQ {

    private QuotationService quotationService;

    private final static String QUEUE_NAME = "simple_queue";

    public QuotationReciverRabbitMQ(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    public void run() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [x] QUEUE_NAME: "+ QUEUE_NAME + ". Waiting for messages.");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                quotationService.saveQuotationFromQueue(message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}