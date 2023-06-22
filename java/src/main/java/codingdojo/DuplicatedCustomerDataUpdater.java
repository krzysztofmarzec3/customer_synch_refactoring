package codingdojo;


class DuplicatedCustomerDataUpdater<T extends Customer> extends CustomerDataUpdaterBasic<T> {

    public DuplicatedCustomerDataUpdater(T customer, ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess) {
        super(customer, externalCustomer, customerDataAccess);
    }

    public final boolean persist() {

        customer.setName(externalCustomer.getName());

        if (customer.isNew()) {
            createCustomer();
        } else {
            updateCustomer();
        }

        boolean created = false;
        if (customer.isNew()) {
            createCustomer();
            created = true;
        } else {
            updateCustomer();
        }
        return created;
    }
}
