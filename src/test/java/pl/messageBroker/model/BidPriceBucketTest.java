package pl.messageBroker.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
public class BidPriceBucketTest {

    BidPriceBucket bidPriceBucket;

    @Before
    public void setUp() throws Exception {
        bidPriceBucket = new BidPriceBucket();
    }

    @Test
    public void getId() {
        Integer idValue = 1;
        bidPriceBucket.setId(idValue);
        assertEquals(idValue, bidPriceBucket.getId());
    }

    @Test
    public void setId() {
        Integer idValue = 1;
        bidPriceBucket.setId(idValue);
        assertEquals(idValue, bidPriceBucket.getId());
    }

    @Test
    public void getPrice() {
        Double priveValue = 1d;
        bidPriceBucket.setPrice(priveValue);
        assertEquals(priveValue, bidPriceBucket.getPrice());
    }

    @Test
    public void setPrice() {
        Double priveValue = 1d;
        bidPriceBucket.setPrice(priveValue);
        assertEquals(priveValue, bidPriceBucket.getPrice());
    }

    @Test
    public void getLiquidity() {
        Integer liquidityValue = 1;
        bidPriceBucket.setLiquidity(liquidityValue);
        assertEquals(liquidityValue, bidPriceBucket.getLiquidity());
    }

    @Test
    public void setLiquidity() {
        Integer liquidityValue = 1;
        bidPriceBucket.setLiquidity(liquidityValue);
        assertEquals(liquidityValue, bidPriceBucket.getLiquidity());
    }
}