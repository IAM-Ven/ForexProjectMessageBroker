package pl.messageBroker.service;

import org.springframework.stereotype.Service;
import pl.messageBroker.model.Quotation;
import pl.messageBroker.model.StringQuotation.StringQuotation;
import pl.messageBroker.repository.QuotationReactiveRepository;
import pl.messageBroker.repository.StringQuotationReactiveRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class QuotationReactiveServiceImpl implements QuotationReactiveService {

    private final StringQuotationReactiveRepository stringQuotationReactiveRepository;
    private final QuotationReactiveRepository quotationReactiveRepository;

    public QuotationReactiveServiceImpl(StringQuotationReactiveRepository stringQuotationReactiveRepository, QuotationReactiveRepository quotationReactiveRepository) {
        this.stringQuotationReactiveRepository = stringQuotationReactiveRepository;
        this.quotationReactiveRepository = quotationReactiveRepository;
    }


    @Override
    public Mono<StringQuotation> saveStringQuotation(StringQuotation stringQuotation) {
        StringQuotation savedStringQuotation = stringQuotationReactiveRepository.save(stringQuotation).block();
        return Mono.just(savedStringQuotation);
    }

    @Override
    public Mono<StringQuotation> saveStringQuotationFromQueue(String quotationBody) {
        StringQuotation savedStringQuotation = stringQuotationReactiveRepository.save(new StringQuotation(quotationBody)).block();
        return Mono.just(savedStringQuotation);
    }

    @Override
    public Mono<List<Quotation>> saveQuotationObjectFromQueue(List<Quotation> quotationList) {
        List<Quotation> savedQuotationList = quotationList.stream()
                .map(quotation -> quotationReactiveRepository.save(quotation).block())
                .collect(Collectors.toList());
        return Mono.just(savedQuotationList);
    }
}
