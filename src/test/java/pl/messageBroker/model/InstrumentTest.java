package pl.messageBroker.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
public class InstrumentTest {

    Instrument instrument;

    @Before
    public void setUp() throws Exception {
        instrument = new Instrument();
    }

    @Test
    public void getId() {
        Integer idValue = 1;
        instrument.setId(idValue);
        assertEquals(idValue, instrument.getId());
    }

    @Test
    public void setId() {
        Integer idValue = 1;
        instrument.setId(idValue);
        assertEquals(idValue, instrument.getId());
    }


    @Test
    public void getDescription() {
        String descriptionValue = "Foo";
        instrument.setDescription(descriptionValue);
        assertEquals(descriptionValue, instrument.getDescription());
    }

    @Test
    public void setDescription() {
        String descriptionValue = "Foo";
        instrument.setDescription(descriptionValue);
        assertEquals(descriptionValue, instrument.getDescription());
    }
}