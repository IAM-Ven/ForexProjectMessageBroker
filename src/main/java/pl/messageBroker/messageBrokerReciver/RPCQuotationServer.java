package pl.messageBroker.messageBrokerReciver;

import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.messageBroker.service.Json2QuotationConverter;
import pl.messageBroker.service.QuotationReactiveService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class RPCQuotationServer {

    @Autowired
    private QuotationReactiveService quotationReactiveService;

    @Autowired
    private Json2QuotationConverter json2QuotationConverter;

    private static final String RPC_QUEUE_NAME = "rcp_queue";

    private static final String FIXED_RESPONSE = "StringQuotation recived correctly";

    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = null;
        try {
            connection      = factory.newConnection();
            final Channel channel = connection.createChannel();

            channel.queueDeclare(RPC_QUEUE_NAME, false, false, false, null);
            channel.queuePurge(RPC_QUEUE_NAME);

            channel.basicQos(1);

            System.out.println(" [x] RPC_QUEUE_NAME: " + RPC_QUEUE_NAME + ". Awaiting RPC requests");

            Consumer consumer = new DefaultConsumer(channel) {

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                            .Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();

                    String response = "";

                    try {
                        String recivedQuotationMessage = new String(body,"UTF-8");
                        System.out.println(" [.] recived qutotation (" + recivedQuotationMessage + ")");
                        quotationReactiveService.saveQuotationFromQueue(recivedQuotationMessage);
                        json2QuotationConverter.Json2QuotationConvert(recivedQuotationMessage);
                        response = FIXED_RESPONSE;
                    }
                    catch (RuntimeException e){
                        System.out.println(" [.] " + e.toString());
                    }
                    finally {
                        channel.basicPublish( "", properties.getReplyTo(), replyProps, response.getBytes("UTF-8"));
                        channel.basicAck(envelope.getDeliveryTag(), false);
                        synchronized(this) {
                            this.notify();
                        }
                    }
                }
            };

            channel.basicConsume(RPC_QUEUE_NAME, false, consumer);
            while (true) {
                synchronized(consumer) {
                    try {
                        consumer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (IOException _ignore) {}
        }
    }
}
