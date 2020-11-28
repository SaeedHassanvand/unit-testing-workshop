package ir.ac.tick.soft.demo.mock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerReaderDemoTest1 {

    @Test
    public void happyPathScenario() {
        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstName("Ali");
        sampleCustomer.setLastName("Akbari");

        EntityManager entityManager = mock(EntityManager.class);
        when(entityManager.find(Customer.class, 1L)).thenReturn(sampleCustomer);

        CustomerReader customerReader = new CustomerReader();
        customerReader.setEntityManager(entityManager);

        String fullName = customerReader.findFullName(1L);
        assertEquals("Ali Akbari", fullName);
    }
}
