package pl.messageBroker.service;

import org.springframework.stereotype.Service;
import pl.messageBroker.model.StringQuotation.StringQuotation;
import pl.messageBroker.repository.QuotationReactiveRepository;
import reactor.core.publisher.Mono;


@Service
public class QuotationReactiveServiceImpl implements QuotationReactiveService {

    private final QuotationReactiveRepository quotationReactiveRepository;

    public QuotationReactiveServiceImpl(QuotationReactiveRepository quotationReactiveRepository) {
        this.quotationReactiveRepository = quotationReactiveRepository;
    }

    @Override
    public Mono<StringQuotation> saveQuotation(StringQuotation stringQuotation) {
        StringQuotation savedStringQuotation = quotationReactiveRepository.save(stringQuotation).block();
        return Mono.just(savedStringQuotation);
    }

    @Override
    public Mono<StringQuotation>  saveQuotationFromQueue(String quotationBody) {
        StringQuotation savedStringQuotation = quotationReactiveRepository.save(new StringQuotation(quotationBody)).block();
        return Mono.just(savedStringQuotation);
    }
}
