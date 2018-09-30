package pl.messageBroker.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.messageBroker.model.StringQuotation.StringQuotation;
import pl.messageBroker.repository.QuotationReactiveRepository;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StringQuotationServiceImplTest {

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
        StringQuotation stringQuotation = new StringQuotation();
        stringQuotation.setId("1");
        stringQuotation.setQuotationBody("Foo");

        //when
        when(quotationReactiveRepository.save(any())).thenReturn(Mono.just(stringQuotation));
        StringQuotation savedStringQuotation = quotationReactiveService.saveQuotation(stringQuotation).block();

        //then
        assertEquals("1", savedStringQuotation.getId());
        verify(quotationReactiveRepository, times(1)).save(any(StringQuotation.class));
    }

    @Test
    public void saveQuotationFromQueue() {
        //given
        String quotationBody = "Foo";
        StringQuotation stringQuotation = new StringQuotation();
        stringQuotation.setId("1");

        //when
        when(quotationReactiveRepository.save(any())).thenReturn(Mono.just(stringQuotation));
        StringQuotation savedStringQuotation = quotationReactiveService.saveQuotationFromQueue(quotationBody).block();

        //then
        assertEquals("1", savedStringQuotation.getId());
        verify(quotationReactiveRepository, times(1)).save(any(StringQuotation.class));

    }
}