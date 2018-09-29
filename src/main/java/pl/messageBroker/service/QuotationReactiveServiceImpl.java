package pl.messageBroker.service;

import org.springframework.stereotype.Service;
import pl.messageBroker.model.Quotation;
import pl.messageBroker.repository.QuotationReactiveRepository;
import reactor.core.publisher.Mono;


@Service
public class QuotationReactiveServiceImpl implements QuotationReactiveService {

    private final QuotationReactiveRepository quotationReactiveRepository;

    public QuotationReactiveServiceImpl(QuotationReactiveRepository quotationReactiveRepository) {
        this.quotationReactiveRepository = quotationReactiveRepository;
    }

    @Override
    public Mono<Quotation> saveQuotation(Quotation quotation) {
        Quotation savedQuotation = quotationReactiveRepository.save(quotation).block();
        return Mono.just(savedQuotation);
    }

    @Override
    public Mono<Quotation>  saveQuotationFromQueue(String quotationBody) {
        Quotation savedQuotation = quotationReactiveRepository.save(new Quotation(quotationBody)).block();
        return Mono.just(savedQuotation);
    }
}
