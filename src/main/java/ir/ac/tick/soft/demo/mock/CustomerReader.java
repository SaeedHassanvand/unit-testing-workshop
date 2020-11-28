package ir.ac.tick.soft.demo.mock;

public class CustomerReader {

    // EntityManager read data from a real database
    private EntityManager entityManager;

    // This method might throws a NullPointerException if customer doesn't exist in the database
    public String findFullName(Long customerID) throws NullPointerException{
        Customer customer = entityManager.find(Customer.class, customerID);
        return customer.getFirstName() +" "+customer.getLastName();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
