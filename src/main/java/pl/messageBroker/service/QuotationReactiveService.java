package pl.messageBroker.service;

import pl.messageBroker.model.Quotation;
import pl.messageBroker.model.StringQuotation.StringQuotation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface QuotationReactiveService {

    Mono<StringQuotation> saveStringQuotation(StringQuotation stringQuotation);

    Mono<StringQuotation> saveStringQuotationFromQueue(String quotationBody);

    Mono<List<Quotation>> saveQuotationObjectFromQueue(List<Quotation> quotationList);
}
