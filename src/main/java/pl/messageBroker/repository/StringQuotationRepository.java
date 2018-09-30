package pl.messageBroker.repository;

import org.springframework.data.repository.CrudRepository;
import pl.messageBroker.model.StringQuotation.StringQuotation;

public interface StringQuotationRepository extends CrudRepository<StringQuotation, String> {
}
