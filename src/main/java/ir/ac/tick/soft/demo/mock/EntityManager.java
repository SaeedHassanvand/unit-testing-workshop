package ir.ac.tick.soft.demo.mock;

import java.util.UUID;

public class EntityManager {

    // Return a new random customer. But must search in database and select a customer based on given ID
    public Customer find(Class<Customer> customerClass, Long customerID) {
        Customer customer = new Customer();
        customer.setId(customerID);
        customer.setFirstName(UUID.randomUUID().toString());
        customer.setLastName(UUID.randomUUID().toString());
        return customer;
    }
}
