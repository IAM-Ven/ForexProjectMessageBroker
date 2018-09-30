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
public class StringQuotationReactiveRepositoryTest {

    @Autowired
    QuotationReactiveRepository quotationReactiveRepository;

    @Before
    public void setUp() throws Exception {
        quotationReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSave() throws Exception {
        StringQuotation stringQuotation = new StringQuotation();
        stringQuotation.setQuotationBody("Foo");

        quotationReactiveRepository.save(stringQuotation).block();

        Long count = quotationReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }
}