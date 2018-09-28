package pl.messageBroker.repository;

import org.springframework.data.repository.CrudRepository;
import pl.messageBroker.model.Quotation;

public interface QuotationRepository extends CrudRepository<Quotation, String> {
}
