package codingdojo;

class CustomerPersonDataSync extends CustomerDataSync<PeopleCustomer> {
    CustomerPersonDataSync(ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess, CustomerDataLayer customerDataLayer) {
        super(externalCustomer, customerDataAccess, customerDataLayer);
    }

    @Override
    protected Customer initNewCustomer(ExternalCustomer.ExternalCustomerId externalId) {
        return new PeopleCustomer(externalId);
    }

    @Override
    protected CustomerMatches createCustomerMatches() {
        return new CustomerMatchesPersonFactory(externalCustomer, customerDataLayer).createCustomerMatches();
    }

    @Override
    protected CustomerDataUpdater createCustomerPersistance(PeopleCustomer customer) {
        return new CustomerPeopleDataUpdater(customer, externalCustomer, customerDataAccess);
    }

    /*@Override
    protected final Customer populateFields(Customer customer) {
        customer.setName(externalCustomer.getName());
        if (!Objects.equals(externalCustomer.getBonusPointsBalance(), ((PeopleCustomer) customer).getBonusPointsBalance())) {
            ((PeopleCustomer) customer).setBonusPointsBalance(externalCustomer.getBonusPointsBalance());
        }
        return customer;
    }*/
}