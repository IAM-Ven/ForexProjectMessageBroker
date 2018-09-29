package pl.messageBroker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Quotation {

    @Id
    private String id;
    private String quotationBody;

    public Quotation(String quotationBody) {
        this.quotationBody = quotationBody;
    }
}
