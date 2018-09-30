package pl.messageBroker.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class AskPriceBucketTest {

    AskPriceBucket askPriceBucket;

    @Before
    public void setUp() throws Exception {
        askPriceBucket = new AskPriceBucket();
    }

    @Test
    public void getId() {
        Integer idValue = 1;
        askPriceBucket.setId(idValue);
        assertEquals(idValue, askPriceBucket.getId());
    }

    @Test
    public void setId() {
        Integer idValue = 1;
        askPriceBucket.setId(idValue);
        assertEquals(idValue, askPriceBucket.getId());
    }

    @Test
    public void getPrice() {
        Double priveValue = 1d;
        askPriceBucket.setPrice(priveValue);
        assertEquals(priveValue, askPriceBucket.getPrice());
    }

    @Test
    public void setPrice() {
        Double priveValue = 1d;
        askPriceBucket.setPrice(priveValue);
        assertEquals(priveValue, askPriceBucket.getPrice());
    }

    @Test
    public void getLiquidity() {
        Integer liquidityValue = 1;
        askPriceBucket.setLiquidity(liquidityValue);
        assertEquals(liquidityValue, askPriceBucket.getLiquidity());
    }

    @Test
    public void setLiquidity() {
        Integer liquidityValue = 1;
        askPriceBucket.setLiquidity(liquidityValue);
        assertEquals(liquidityValue, askPriceBucket.getLiquidity());
    }
}