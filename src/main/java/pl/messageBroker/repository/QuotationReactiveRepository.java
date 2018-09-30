package pl.messageBroker.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.messageBroker.model.StringQuotation.StringQuotation;

public interface QuotationReactiveRepository extends ReactiveMongoRepository<StringQuotation, String> {
}
