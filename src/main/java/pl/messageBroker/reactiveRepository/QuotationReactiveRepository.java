package pl.messageBroker.reactiveRepository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pl.messageBroker.model.Quotation;

public interface QuotationReactiveRepository extends ReactiveMongoRepository<Quotation, String> {
}
