package pl.messageBroker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.messageBroker.model.StringQuotation.StringQuotation;
import pl.messageBroker.repository.StringQuotationRepository;


@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private StringQuotationRepository stringQuotationRepository;

    @Override
    public void saveQuotation(StringQuotation stringQuotation) {
        stringQuotationRepository.save(stringQuotation);
    }

    @Override
    public void saveQuotationStringFromQueue(String quotationBody) {
        stringQuotationRepository.save(new StringQuotation(quotationBody));
    }
}

