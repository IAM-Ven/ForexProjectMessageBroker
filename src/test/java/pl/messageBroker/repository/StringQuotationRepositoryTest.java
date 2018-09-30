package pl.messageBroker.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.messageBroker.model.StringQuotation.StringQuotation;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class StringQuotationRepositoryTest {

    @Autowired
    StringQuotationRepository stringQuotationRepository;

    @Before
    public void setUp() throws Exception {
        stringQuotationRepository.deleteAll();
    }

    @Test
    public void testSave() throws Exception {
        StringQuotation stringQuotation = new StringQuotation();
        stringQuotation.setQuotationBody("Foo");

        stringQuotationRepository.save(stringQuotation);

        Long count = stringQuotationRepository.count();

        assertEquals(Long.valueOf(1L), count);
    }
}