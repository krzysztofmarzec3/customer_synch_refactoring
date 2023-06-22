package codingdojo;

public interface CustomerDataReadLayer {

    Customer findByExternalId(ExternalCustomer.ExternalCustomerId externalId);

    Customer findByMasterExternalId(String externalId);

    Customer findByCompanyNumber(String companyNumber);
}
