package pl.messageBroker.service;

import pl.messageBroker.model.StringQuotation.StringQuotation;
import reactor.core.publisher.Mono;

public interface QuotationReactiveService {

    Mono<StringQuotation> saveQuotation(StringQuotation stringQuotation);

    Mono<StringQuotation> saveQuotationFromQueue(String quotationBody);
}
