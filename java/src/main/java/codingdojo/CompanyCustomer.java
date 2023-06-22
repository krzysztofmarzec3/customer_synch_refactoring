package codingdojo;

class CompanyCustomer extends Customer {

    CompanyCustomer(ExternalCustomer.ExternalCustomerId externalId) {
        super(externalId, CustomerType.COMPANY);
    }

    static Customer createWith(Customer matchByCompanyNumber, ExternalCustomer.ExternalCustomerId externalId) {
        final CompanyCustomer companyCustomer = new CompanyCustomer(externalId);
        companyCustomer.setCompanyNumber(matchByCompanyNumber.getCompanyNumber());
        companyCustomer.setMasterExternalId(externalId.getExternalId());
        companyCustomer.updateWith(new CustomerUpdateRequest(
                matchByCompanyNumber.getName(),
                matchByCompanyNumber.getShoppingLists(),
                matchByCompanyNumber.getPreferredStore(),
                matchByCompanyNumber.getAddress()));
        companyCustomer.setInternalId(matchByCompanyNumber.getInternalId());
        return companyCustomer;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
