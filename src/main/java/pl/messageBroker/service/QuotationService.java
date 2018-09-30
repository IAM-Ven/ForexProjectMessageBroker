package pl.messageBroker.service;

import pl.messageBroker.model.StringQuotation.StringQuotation;

public interface QuotationService {

    void saveQuotation(StringQuotation stringQuotation);

    void saveQuotationStringFromQueue(String quotationBody);
}
