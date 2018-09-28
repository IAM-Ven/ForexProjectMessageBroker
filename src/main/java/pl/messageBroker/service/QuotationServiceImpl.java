package pl.messageBroker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.messageBroker.model.Quotation;
import pl.messageBroker.repository.QuotationRepository;


@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Override
    public void saveQuotation(Quotation quotation) {
        quotationRepository.save(quotation);
    }

    @Override
    public void saveQuotationFromQueue(String quotationBody) {
        quotationRepository.save(new Quotation(quotationBody));
    }
}

