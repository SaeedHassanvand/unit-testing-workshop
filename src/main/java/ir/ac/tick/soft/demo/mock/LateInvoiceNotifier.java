package ir.ac.tick.soft.demo.mock;

public class LateInvoiceNotifier {

    private final EmailSender emailSender;
    private final InvoiceStorage invoiceStorage;

    public LateInvoiceNotifier(final EmailSender emailSender, final InvoiceStorage invoiceStorage) {
        this.emailSender = emailSender;
        this.invoiceStorage = invoiceStorage;
    }

    public void notifyIfLate(Customer customer) {
        if (invoiceStorage.hasOutstandingInvoice(customer)) {
            emailSender.sendEmail(customer);
        }
    }
}