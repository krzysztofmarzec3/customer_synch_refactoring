package codingdojo;

class CustomerMatchesByPeopleExternalId extends CustomerMatches<PeopleCustomer> {

    public CustomerMatchesByPeopleExternalId(Customer matchByExternalId) {
        super();
        customer = matchByExternalId;
    }
}
