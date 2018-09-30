package pl.messageBroker.service;

import pl.messageBroker.model.StringQuotation.StringQuotation;

public interface QuotationService {

    void saveQuotation(StringQuotation stringQuotation);

    void saveQuotationFromQueue(String quotationBody);
}
