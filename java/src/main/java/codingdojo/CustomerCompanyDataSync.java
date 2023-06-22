package codingdojo;

import codingdojo.ExternalCustomer.ExternalCustomerId;

class CustomerCompanyDataSync extends CustomerDataSync<CompanyCustomer> {

    CustomerCompanyDataSync(ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess, CustomerDataLayer customerDataLayer) {
        super(externalCustomer, customerDataAccess, customerDataLayer);
    }

    @Override
    protected CustomerDataUpdater<CompanyCustomer> createCustomerPersistance(CompanyCustomer customer) {
        return new CustomerCompanyDataUpdater(customer, externalCustomer, customerDataAccess);
    }

    @Override
    protected Customer initNewCustomer(ExternalCustomerId externalId) {
        return new CompanyCustomer(externalId);
    }

    @Override
    protected CustomerMatches createCustomerMatches() {
        return new CustomerMatchesCompanyFactory(externalCustomer, customerDataLayer).createCustomerMatches();
    }

}
