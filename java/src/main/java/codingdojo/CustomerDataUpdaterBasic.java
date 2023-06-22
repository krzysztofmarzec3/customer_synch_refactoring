package codingdojo;

public class CustomerDataUpdaterBasic<T extends Customer> {

    protected final T customer;
    protected final ExternalCustomer externalCustomer;
    private final CustomerDataAccess customerDataAccess;
    public CustomerDataUpdaterBasic(T customer, ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess) {
        this.customer = customer;
        this.externalCustomer = externalCustomer;
        this.customerDataAccess = customerDataAccess;
    }

    protected Customer updateCustomer() {
        return this.customerDataAccess.updateCustomerRecord(customer);
    }

    protected Customer createCustomer() {
        return this.customerDataAccess.createCustomerRecord(customer);
    }
}
