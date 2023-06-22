package codingdojo;

public class CustomerPeopleDataUpdater extends CustomerDataUpdater<PeopleCustomer> {

    public CustomerPeopleDataUpdater(PeopleCustomer customer, ExternalCustomer externalCustomer, CustomerDataAccess customerDataAccess) {
        super(customer, externalCustomer, customerDataAccess);
    }

    @Override
    protected void updateTypeDependentFields(PeopleCustomer customer) {
        customer.updateBonusPointsBalance(externalCustomer.getBonusPointsBalance());
    }
}
