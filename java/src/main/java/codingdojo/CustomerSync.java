package codingdojo;

public class CustomerSync {

    private final CustomerDataAccess customerDataAccess;
    private final CustomerDataLayer customerDataLayer;

    public CustomerSync(CustomerDataLayer customerDataLayer) {
        this(new CustomerDataAccess(customerDataLayer), customerDataLayer);
    }

    private CustomerSync(CustomerDataAccess db, CustomerDataLayer customerDataLayer) {
        this.customerDataAccess = db;
        this.customerDataLayer = customerDataLayer;
    }

    public boolean syncWithDataLayer(ExternalCustomer externalCustomer) {

        CustomerDataSync<? extends Customer> customerDataSync;
        if (externalCustomer.isCompany()) {
            customerDataSync = new CustomerCompanyDataSync(externalCustomer, customerDataAccess, customerDataLayer);
        } else {
            customerDataSync = new CustomerPersonDataSync(externalCustomer, customerDataAccess, customerDataLayer);
        }
        return customerDataSync.processData();
    }
}
