package pl.messageBroker.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.messageBroker.messageBrokerReciver.QuotationReciverRabbitMQ;
import pl.messageBroker.messageBrokerReciver.RPCQuotationServer;
import pl.messageBroker.model.Quotation;
import pl.messageBroker.service.QuotationService;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private QuotationService quotationService;

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
        quotationService.saveQuotation(new Quotation("test quote"));
    }
}
