package codingdojo;

public class CustomerCompanyDataUpdater extends CustomerDataUpdater<CompanyCustomer> {

    public CustomerCompanyDataUpdater(CompanyCustomer customer, ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess) {
        super(customer, externalCustomer, customerDataAccess);
    }

    @Override
    protected void updateTypeDependentFields(CompanyCustomer customer) {
        customer.setCompanyNumber(externalCustomer.getCompanyNumber());
    }
}
