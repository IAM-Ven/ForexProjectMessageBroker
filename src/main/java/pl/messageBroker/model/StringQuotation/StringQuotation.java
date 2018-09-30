package pl.messageBroker.model.StringQuotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
public class StringQuotation {

    @Id
    private String id;
    private String quotationBody;

    public StringQuotation(String quotationBody) {
        this.quotationBody = quotationBody;
    }
}
