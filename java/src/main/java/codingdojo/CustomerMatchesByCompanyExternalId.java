package codingdojo;

class CustomerMatchesByCompanyExternalId extends CustomerMatches<CompanyCustomer> {

    public CustomerMatchesByCompanyExternalId(Customer matchByExternalId) {
        super();
        customer = matchByExternalId;
    }
}
