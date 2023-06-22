package codingdojo;


class CustomerMatchesPersonFactory {

    private final ExternalCustomer externalCustomer;
    private final CustomerDataLayer customerDataLayer;

    CustomerMatchesPersonFactory(ExternalCustomer externalCustomer, CustomerDataLayer customerDataLayer) {
        this.externalCustomer = externalCustomer;
        this.customerDataLayer = customerDataLayer;
    }

    CustomerMatches createCustomerMatches() {
        Customer matchByPersonalNumber = this.customerDataLayer.findByExternalId(externalCustomer.getExternalId());
        if (matchByPersonalNumber != null) {
            if (CustomerType.PERSON != (matchByPersonalNumber.getCustomerType())) {
                throw new ConflictException("Existing customer for externalCustomer " + externalCustomer.getExternalId() + " already exists and is not a person");
            }
            return new CustomerMatchesByPeopleExternalId(matchByPersonalNumber);
        } else {
            return new CustomerMatchesNonePerson();
        }

    }

}
