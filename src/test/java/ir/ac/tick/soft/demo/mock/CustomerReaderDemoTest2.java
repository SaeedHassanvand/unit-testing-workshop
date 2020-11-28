package ir.ac.tick.soft.demo.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerReaderDemoTest2 {

    // Class to be tested
    private CustomerReader customerReader;

    // Dependencies to be injected (will be mocked)
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        customerReader = new CustomerReader();

        entityManager = mock(EntityManager.class);
        customerReader.setEntityManager(entityManager);
    }

    @Test
    public void happyPathScenario() {
        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstName("Ali");
        sampleCustomer.setLastName("Akbari");

        when(entityManager.find(Customer.class, 1L)).thenReturn(sampleCustomer);

        String fullName = customerReader.findFullName(1L);
        assertEquals("Ali Akbari", fullName);
    }

    @Test
    public void customerNotPresentInDb() {
        when(entityManager.find(Customer.class, 1L)).thenReturn(null);

        assertThrows(NullPointerException.class, () -> {
            customerReader.findFullName(1L);
        });
    }
}
