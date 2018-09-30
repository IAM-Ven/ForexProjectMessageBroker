package pl.messageBroker.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.messageBroker.model.StringQuotation.StringQuotation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class Json2QuotationConverterImplTest {

    private final String JSON_BODY = "[{\"quotationBody\":\"Foo\"}, {\"quotationBody\":\"Bar\"}]";

    ObjectMapper objectMapper = new ObjectMapper();

    List<StringQuotation> stringQuotationList;

    @Before
    public void setUp() throws Exception {
        StringQuotation stringQuotation1 = new StringQuotation();
        stringQuotation1.setQuotationBody("Foo");
        StringQuotation stringQuotation2 = new StringQuotation();
        stringQuotation2.setQuotationBody("Bar");

        stringQuotationList = new ArrayList<>();
        stringQuotationList.add(stringQuotation1);
        stringQuotationList.add(stringQuotation2);
    }

    @Test
    public void json2QuotationConvert() {
        List<StringQuotation> stringQuotationListFromJson = new ArrayList<>();
        try {
            stringQuotationListFromJson = objectMapper.readValue(JSON_BODY, new TypeReference<List<StringQuotation>>(){});

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertEquals(stringQuotationList.size(), stringQuotationListFromJson.size());
        assertEquals(stringQuotationList.get(0).getId(), stringQuotationListFromJson.get(0).getId());
        assertEquals(stringQuotationList.get(1).getId(), stringQuotationListFromJson.get(1).getId());

    }
}