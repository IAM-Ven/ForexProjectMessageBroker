package pl.messageBroker.service;

import pl.messageBroker.model.Quotation;
import reactor.core.publisher.Mono;

public interface QuotationReactiveService {

    Mono<Quotation> saveQuotation(Quotation quotation);

    void saveQuotationFromQueue(String quotationBody);
}
