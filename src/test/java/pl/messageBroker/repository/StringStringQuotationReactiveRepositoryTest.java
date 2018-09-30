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
public class StringStringQuotationReactiveRepositoryTest {

    @Autowired
    StringQuotationReactiveRepository stringQuotationReactiveRepository;

    @Before
    public void setUp() throws Exception {
        stringQuotationReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        StringQuotation stringQuotation = new StringQuotation();
        stringQuotation.setQuotationBody("Foo");

        stringQuotationReactiveRepository.save(stringQuotation).block();

        Long count = stringQuotationReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }
}