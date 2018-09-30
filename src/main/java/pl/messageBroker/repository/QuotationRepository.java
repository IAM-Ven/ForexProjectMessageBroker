package pl.messageBroker.repository;

import org.springframework.data.repository.CrudRepository;
import pl.messageBroker.model.StringQuotation.StringQuotation;

public interface QuotationRepository extends CrudRepository<StringQuotation, String> {
}
