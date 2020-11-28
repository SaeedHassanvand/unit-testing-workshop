package ir.ac.tick.soft.demo.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LateInvoiceNotifierTest {

    // Class to be tested
    private LateInvoiceNotifier lateInvoiceNotifier;

    // Dependencies to be injected (will be mocked)
    private EmailSender emailSender;
    private InvoiceStorage invoiceStorage;

    // Test data
    private Customer sampleCustomer;

    @BeforeEach
    public void setup() {
        // Instantiate mock objects
        invoiceStorage = mock(InvoiceStorage.class);
        emailSender = mock(EmailSender.class);

        // Inject required dependencies
        lateInvoiceNotifier = new LateInvoiceNotifier(emailSender, invoiceStorage);

        // Create test data
        sampleCustomer = new Customer();
        sampleCustomer.setFirstName("Ali");
        sampleCustomer.setLastName("Akbari");
    }

    @Test
    public void lateInvoice() {
        when(invoiceStorage.hasOutstandingInvoice(sampleCustomer)).thenReturn(true);

        lateInvoiceNotifier.notifyIfLate(sampleCustomer);

        // Check the side effect
        verify(emailSender).sendEmail(sampleCustomer);
    }

    @Test
    public void noLateInvoicePresent() {
        when(invoiceStorage.hasOutstandingInvoice(sampleCustomer)).thenReturn(false);

        lateInvoiceNotifier.notifyIfLate(sampleCustomer);

        // Check the side effect
        verify(emailSender, times(0)).sendEmail(sampleCustomer);
    }

}
