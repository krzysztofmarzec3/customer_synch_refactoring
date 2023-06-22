package codingdojo;


abstract class CustomerDataUpdater<T extends Customer> extends CustomerDataUpdaterBasic<T> {

    public CustomerDataUpdater(T customer, ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess) {
        super(customer, externalCustomer, customerDataAccess);
    }

    public final boolean persist() {
        updateTypeDependentFields(customer);
        customer.updateWith(new CustomerUpdateRequest(externalCustomer.getName(),
                externalCustomer.getShoppingLists(),
                externalCustomer.getPreferredStore(),
                externalCustomer.getPostalAddress()
        ));

        boolean created = false;
        if (customer.isNew()) {
            createCustomer();
            created = true;
        } else {
            updateCustomer();
        }
        return created;
    }

    protected abstract void updateTypeDependentFields(T customer);

}
