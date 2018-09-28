package pl.messageBroker.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.messageBroker.messageBrokerReciver.QuotationReciverRabbitMQ;
import pl.messageBroker.messageBrokerReciver.RPCQuotationServer;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            QuotationReciverRabbitMQ.run();
            RPCQuotationServer.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
