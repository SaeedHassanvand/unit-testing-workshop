package ir.ac.tick.soft.demo.mock;

import java.util.Random;

/**
 * In a real system, the InvoiceStorage class is actually a web service
 * that connects with an external legacy CRM system which is slow.
 * A unit test could never make use of such a web service.
 */
public class InvoiceStorage {

    // Return a random value
    public boolean hasOutstandingInvoice(Customer customer) {
        return new Random().nextBoolean();
    }
}
