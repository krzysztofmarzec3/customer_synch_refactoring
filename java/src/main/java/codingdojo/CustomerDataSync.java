package codingdojo;

abstract class CustomerDataSync<T extends Customer> {
    protected final ExternalCustomer externalCustomer;
    protected final CustomerDataAccess customerDataAccess;
    protected final CustomerDataLayer customerDataLayer;

    public CustomerDataSync(ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess, CustomerDataLayer customerDataLayer) {
        this.externalCustomer = externalCustomer;
        this.customerDataAccess = customerDataAccess;
        this.customerDataLayer = customerDataLayer;
    }

    public boolean processData() {
        final CustomerMatches<T> customerMatches = createCustomerMatches();
        Customer customer = customerMatches.getCustomer();

        if (customer == null) {
            customer = createNewCustomer();
        }

        if (customerMatches.hasDuplicates()) {
            for (Customer duplicate : customerMatches.getDuplicates()) {
                if (duplicate == null) {
                    duplicate = createNewCustomer();
                }
                new DuplicatedCustomerDataUpdater<>(duplicate, externalCustomer, customerDataAccess).persist();
            }
        }

        return createCustomerPersistance((T) customer).persist();
    }

    protected abstract CustomerDataUpdater<T> createCustomerPersistance(T customer);

    private Customer createNewCustomer() {
        Customer customer;
        customer = initNewCustomer(externalCustomer.getExternalId());
        customer.setMasterExternalId(externalCustomer.getExternalId() != null ? externalCustomer.getExternalId().getExternalId() : null);
        return customer;
    }

    protected abstract Customer initNewCustomer(ExternalCustomer.ExternalCustomerId externalId);

    protected abstract CustomerMatches<T> createCustomerMatches();
}
