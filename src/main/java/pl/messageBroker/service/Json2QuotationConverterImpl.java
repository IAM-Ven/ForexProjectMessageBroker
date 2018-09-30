package pl.messageBroker.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.messageBroker.model.Quotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Json2QuotationConverterImpl implements Json2QuotationConverter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Quotation> Json2QuotationConvert(String quotationBody) {
        List<Quotation> quotationList = new ArrayList<Quotation>();
        try {
            quotationList = objectMapper.readValue(quotationBody, new TypeReference<List<Quotation>>(){});
            System.out.println("converter message to list object: " + quotationList);

            //Pretty print
            String prettyQuotationList = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(quotationList);
            System.out.println("PRETTY: converter message to list object: " + prettyQuotationList);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quotationList;
    }
}
