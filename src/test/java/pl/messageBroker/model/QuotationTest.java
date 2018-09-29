package pl.messageBroker.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuotationTest {

    Quotation quotation;

    @Before
    public void setUp() throws Exception {
    quotation = new Quotation();
    }

    @Test
    public void getId() {
        String idValue = "1";

        quotation.setId(idValue);

        assertEquals(idValue, quotation.getId());
    }

    @Test
    public void getQuotationBody() {
        String quotationBody = "quotation body";

        quotation.setQuotationBody(quotationBody);

        assertEquals(quotationBody, quotation.getQuotationBody());

    }
}