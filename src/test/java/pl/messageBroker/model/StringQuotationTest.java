package pl.messageBroker.model;

import org.junit.Before;
import org.junit.Test;
import pl.messageBroker.model.StringQuotation.StringQuotation;

import static org.junit.Assert.assertEquals;

public class StringQuotationTest {

    StringQuotation stringQuotation;

    @Before
    public void setUp() throws Exception {
    stringQuotation = new StringQuotation();
    }

    @Test
    public void getId() {
        String idValue = "1";

        stringQuotation.setId(idValue);

        assertEquals(idValue, stringQuotation.getId());
    }

    @Test
    public void getQuotationBody() {
        String quotationBody = "stringQuotation body";

        stringQuotation.setQuotationBody(quotationBody);

        assertEquals(quotationBody, stringQuotation.getQuotationBody());

    }
}