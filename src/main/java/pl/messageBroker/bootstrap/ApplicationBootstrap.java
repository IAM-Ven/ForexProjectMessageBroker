package pl.messageBroker.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.messageBroker.messageBrokerReciver.QuotationReciverRabbitMQ;
import pl.messageBroker.messageBrokerReciver.RPCQuotationServer;
import pl.messageBroker.model.StringQuotation.StringQuotation;
import pl.messageBroker.service.QuotationReactiveService;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuotationReactiveService quotationReactiveService;

    @Autowired
    private RPCQuotationServer rpcQuotationServer;

    @Autowired
    private QuotationReciverRabbitMQ quotationReciverRabbitMQ;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initData();
        try {
            quotationReciverRabbitMQ.run();
            rpcQuotationServer.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void initData() {
        quotationReactiveService.saveQuotation(new StringQuotation("test quote"));
    }
}
