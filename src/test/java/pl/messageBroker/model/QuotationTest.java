package pl.messageBroker.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class QuotationTest {

    Quotation quotation;
    AskPriceBucket askPriceBucket;
    BidPriceBucket bidPriceBucket;
    Instrument instrument;

    @Before
    public void setUp() throws Exception {
        quotation = new Quotation();
        askPriceBucket = new AskPriceBucket();
        bidPriceBucket = new BidPriceBucket();
        instrument = new Instrument();
    }

    @Test
    public void getId() {
        Integer idValue = 1;
        quotation.setId(idValue);
        assertEquals(idValue, quotation.getId());
    }

    @Test
    public void setId() {
        Integer idValue = 1;
        quotation.setId(idValue);
        assertEquals(idValue, quotation.getId());
    }

    @Test
    public void getDate() {
        String dateValue = "Foo";
        quotation.setDate(dateValue);
        assertEquals(dateValue, quotation.getDate());
    }

    @Test
    public void setDate() {
        String dateValue = "Foo";
        quotation.setDate(dateValue);
        assertEquals(dateValue, quotation.getDate());
    }

    @Test
    public void getTime() {
        String timeValue = "Foo";
        quotation.setTime(timeValue);
        assertEquals(timeValue, quotation.getTime());
    }

    @Test
    public void setTime() {
        String timeValue = "Foo";
        quotation.setTime(timeValue);
        assertEquals(timeValue, quotation.getTime());
    }

    @Test
    public void getInstrument() {
        quotation.setInstrument(instrument);
        assertEquals(instrument, quotation.getInstrument());
    }

    @Test
    public void setInstrument() {
        quotation.setInstrument(instrument);
        assertEquals(instrument, quotation.getInstrument());
    }

    @Test
    public void getBidPriceBucket() {
        quotation.setBidPriceBucket(bidPriceBucket);
        assertEquals(bidPriceBucket, quotation.getBidPriceBucket());
    }

    @Test
    public void setBidPriceBucket() {
        quotation.setBidPriceBucket(bidPriceBucket);
        assertEquals(bidPriceBucket, quotation.getBidPriceBucket());
    }

    @Test
    public void getAskPriceBucket() {
        quotation.setAskPriceBucket(askPriceBucket);
        assertEquals(askPriceBucket, quotation.getAskPriceBucket());
    }

    @Test
    public void setAskPriceBucket() {
        quotation.setAskPriceBucket(askPriceBucket);
        assertEquals(askPriceBucket, quotation.getAskPriceBucket());
    }

    @Test
    public void getDocumentId() {
        String idValue = "1";
        quotation.setDocumentId(idValue);
        assertEquals(idValue, quotation.getDocumentId());
    }

    @Test
    public void setDocumentId() {
        String idValue = "1";
        quotation.setDocumentId(idValue);
        assertEquals(idValue, quotation.getDocumentId());
    }
}