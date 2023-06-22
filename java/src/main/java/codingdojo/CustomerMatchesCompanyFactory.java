package codingdojo;


class CustomerMatchesCompanyFactory {

    private final ExternalCustomer externalCustomer;
    private final CustomerDataLayer customerDataLayer;

    CustomerMatchesCompanyFactory(ExternalCustomer externalCustomer, CustomerDataLayer customerDataLayer) {
        this.externalCustomer = externalCustomer;
        this.customerDataLayer = customerDataLayer;
    }

    CustomerMatches createCustomerMatches() {
        final ExternalCustomer.ExternalCustomerId externalId = externalCustomer.getExternalId();
        final String companyNumber = externalCustomer.getCompanyNumber();
        Customer matchByExternalId = this.customerDataLayer.findByExternalId(externalId);

        CustomerMatches matches;
        if (matchByExternalId != null) {
            Customer matchByMasterId = this.customerDataLayer.findByMasterExternalId(externalId.getExternalId());
            if (CustomerType.COMPANY != matchByExternalId.getCustomerType()) {
                throw new ConflictException("Existing customer for externalCustomer " + externalId + " already exists and is not a company");
            }
            String customerCompanyNumber = matchByExternalId.getCompanyNumber();
            if (!companyNumber.equals(customerCompanyNumber)) {
                matches = new CustomerMatchesByCompanyExternalIdNotMatchingCompanyNumber();
                matchByExternalId.setMasterExternalId(null);
                matches.addDuplicate(matchByExternalId);
                if (matchByMasterId != null) {
                    matches.addDuplicate(matchByMasterId);
                }
                return matches;
            }

            matches = new CustomerMatchesByCompanyExternalId(matchByExternalId);
            if (matchByMasterId != null) {
                matches.addDuplicate(matchByMasterId);
            }
        } else {
            Customer matchByCompanyNumber = this.customerDataLayer.findByCompanyNumber(companyNumber);
            if (matchByCompanyNumber != null) {

                ExternalCustomer.ExternalCustomerId customerExternalId = matchByCompanyNumber.getExternalId();
                if (customerExternalId != null && !externalId.equals(customerExternalId)) {
                    throw new ConflictException("Existing customer for externalCustomer " + companyNumber + " doesn't match external id " + externalId + " instead found " + customerExternalId);
                }
                matches = new CustomerMatchesByCompanyNumber(CompanyCustomer.createWith(matchByCompanyNumber, externalId));
            } else {
                matches = new NoneCustomerMatches();
            }
        }

        return matches;
    }
}
