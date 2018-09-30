package pl.messageBroker.service;

import pl.messageBroker.model.Quotation;

import java.util.List;

public interface Json2QuotationConverter {

    List<Quotation> Json2QuotationConvert(String quotationBody);
}
