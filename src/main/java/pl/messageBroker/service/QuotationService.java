package pl.messageBroker.service;

import pl.messageBroker.model.Quotation;

public interface QuotationService {

    void saveQuotation(Quotation quotation);

    void saveQuotationFromQueue(String quotationBody);
}
