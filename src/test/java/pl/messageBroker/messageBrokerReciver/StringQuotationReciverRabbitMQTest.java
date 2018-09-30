package pl.messageBroker.messageBrokerReciver;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.messageBroker.service.QuotationService;

public class StringQuotationReciverRabbitMQTest {

    @Mock
    QuotationService quotationService;

    String QUEUE_NAME = "simple_queue";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        QuotationReciverRabbitMQ quotationReciverRabbitMQ = new QuotationReciverRabbitMQ(quotationService);
    }
    @Test
    public void run() {
    }

}