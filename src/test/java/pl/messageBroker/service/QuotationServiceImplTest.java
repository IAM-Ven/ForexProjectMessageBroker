package pl.messageBroker.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.messageBroker.model.Quotation;
import pl.messageBroker.repository.QuotationReactiveRepository;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class QuotationServiceImplTest {

    @Mock
    QuotationReactiveRepository quotationReactiveRepository;

    QuotationReactiveService quotationReactiveService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        quotationReactiveService = new QuotationReactiveServiceImpl(quotationReactiveRepository);
    }

    @Test
    public void saveQuotation() {
        //given
        Quotation quotation = new Quotation();
        quotation.setId("1");
        quotation.setQuotationBody("Foo");

        //when
        when(quotationReactiveRepository.save(any())).thenReturn(Mono.just(quotation));
        Quotation savedQuotation = quotationReactiveService.saveQuotation(quotation).block();

        //then
        assertEquals("1", savedQuotation.getId());
        verify(quotationReactiveRepository, times(1)).save(any(Quotation.class));
    }

    @Test
    public void saveQuotationFromQueue() {
        //given
        String quotationBody = "Foo";
        Quotation quotation = new Quotation();
        quotation.setId("1");

        //when
        when(quotationReactiveRepository.save(any())).thenReturn(Mono.just(quotation));
        Quotation savedQuotation = quotationReactiveService.saveQuotationFromQueue(quotationBody).block();

        //then
        assertEquals("1", savedQuotation.getId());
        verify(quotationReactiveRepository, times(1)).save(any(Quotation.class));

    }
}