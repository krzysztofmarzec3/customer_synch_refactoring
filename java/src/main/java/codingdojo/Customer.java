package codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

abstract class Customer {
    private final ExternalCustomer.ExternalCustomerId externalId; //TODO change to object of type CustomerExternalId
    private final CustomerType customerType;
    private String masterExternalId; //TODO change to object of type CustomerMasterExternalId
    private Address address;
    private String preferredStore;
    private List<ShoppingList> shoppingLists = new ArrayList<>();
    private String internalId;
    private String name;
    private String companyNumber; //TODO change to object of type CustomerCompanyNumber

    protected Customer(ExternalCustomer.ExternalCustomerId externalId, CustomerType customerType) {
        this.externalId = externalId;
        this.customerType = customerType;
    }

    void setMasterExternalId(String masterExternalId) {
        this.masterExternalId = masterExternalId;
    }

    public String getMasterExternalId() {
        return masterExternalId;
    }

    void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getInternalId() {
        return internalId;
    }

    void setName(String name) {
        this.name = name;
    }

    private void setPreferredStore(String preferredStore) {
        this.preferredStore = preferredStore;
    }

    public String getPreferredStore() {
        return preferredStore;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    List<ShoppingList> getShoppingLists() {
        return Collections.unmodifiableList(shoppingLists);
    }

    void setShoppingLists(List<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }

    public String getName() {
        return name;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public ExternalCustomer.ExternalCustomerId getExternalId() {
        return externalId;
    }

    void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public void addShoppingList(ShoppingList consumerShoppingList) {
        ArrayList<ShoppingList> newList = new ArrayList<>(this.shoppingLists);
        newList.add(consumerShoppingList);
        this.setShoppingLists(newList);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(externalId, customer.externalId) &&
                Objects.equals(masterExternalId, customer.masterExternalId) &&
                Objects.equals(companyNumber, customer.companyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, masterExternalId, companyNumber);
    }

    public boolean isNew() {
        return getInternalId() == null;
    }

    public void updateWith(CustomerUpdateRequest customerUpdateRequest) {
        setName(customerUpdateRequest.getName());
        updateRelations(customerUpdateRequest.getShoppingLists());
        setPreferredStore(customerUpdateRequest.getPreferredStore());
        setAddress(customerUpdateRequest.getPostalAddress());
    }

    private void updateRelations(List<ShoppingList> consumerShoppingLists) {
        for (ShoppingList consumerShoppingList : consumerShoppingLists) {
            addShoppingList(consumerShoppingList);
        }
    }
}
